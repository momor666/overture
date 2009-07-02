/*******************************************************************************
 *
 *	Copyright (c) 2009 Fujitsu Services Ltd.
 *
 *	Author: Nick Battle
 *
 *	This file is part of VDMJ.
 *
 *	VDMJ is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *
 *	VDMJ is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *
 *	You should have received a copy of the GNU General Public License
 *	along with VDMJ.  If not, see <http://www.gnu.org/licenses/>.
 *
 ******************************************************************************/

package org.overturetool.vdmj.runtime;

import org.overturetool.vdmj.messages.Console;
import org.overturetool.vdmj.values.CPUValue;
import org.overturetool.vdmj.values.ObjectValue;
import org.overturetool.vdmj.values.OperationValue;
import org.overturetool.vdmj.values.ValueList;

public class AsyncThread extends Thread
{
	public MessageQueue<MessageRequest> queue;
	public final ObjectValue self;
	public final OperationValue operation;

	public AsyncThread(ObjectValue self, OperationValue operation)
	{
		this.self = self;
		this.operation = operation;
		this.queue = new MessageQueue<MessageRequest>();
	}

	@Override
	public void run()
	{
		CPUValue cpu = self.getCPU();

		Console.out.println(
			"ThreadCreate -> id: " + Thread.currentThread().getId() +
			" period: false objref: " + self.objectReference +
			" clnm: " + self.type.name +
			" cpunm: " + cpu.cpuNumber +
			" time: " + VDMThreadSet.getWallTime());

		MessageRequest request = queue.take();		// Blocking
		ValueList arglist = request.args;

		cpu.activate();
		MessageResponse response = null;

		try
		{
    		RootContext global = ClassInterpreter.getInstance().initialContext;
    		Context ctxt = new ObjectContext(operation.name.location, "async", global, self);
    		ctxt.setThreadState(null, cpu);
    		response = new MessageResponse(operation.eval(arglist, ctxt), request);
		}
		catch (ValueException e)
		{
			response = new MessageResponse(e, request);
		}

		request.bus.reply(response, request);
		cpu.passivate();

		Console.out.println(
			"ThreadKill -> id: " + Thread.currentThread().getId() +
			" cpunm: " + cpu.cpuNumber +
			" time: " + VDMThreadSet.getWallTime() +
			" msg: AAAaaaarrgggg!!!");
	}
}
