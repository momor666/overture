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

import org.overturetool.vdmj.values.CPUValue;

public class Holder<T>
{
	private ControlQueue cq = new ControlQueue();
	private T contents = null;

	public synchronized void set(T object)
	{
		contents = object;
		cq.stim();
	}

	public T get(CPUValue cpu)
	{
		cq.join(cpu);
		cq.block();

		T result = null;

		synchronized (this)
		{
			result = contents;
		}

		cq.leave();

		return result;
	}
}
