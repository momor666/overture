/*******************************************************************************
 *
 *	Copyright (C) 2008 Fujitsu Services Ltd.
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

package org.overture.pog.obligations;

import org.overture.ast.expressions.PExp;
import org.overture.ast.patterns.PPattern;
import org.overture.ast.patterns.assistants.PPatternAssistantTC;
import org.overture.ast.types.PType;


public class POCaseContext extends POContext
{
	public final PPattern pattern;
	public final PType type;
	public final PExp exp;

	public POCaseContext(PPattern pattern, PType type, PExp exp)
	{
		this.pattern = pattern;
		this.type = type;
		this.exp = exp;
	}

	@Override
	public String getContext()
	{
		StringBuilder sb = new StringBuilder();

		if (PPatternAssistantTC.getAllVariableNames(pattern).size() == 0)
		{
    		sb.append(pattern);
    		sb.append(" = ");
    		sb.append(exp);
    		sb.append(" => ");
		}
		else
		{
    		sb.append("exists ");
    		sb.append(pattern);
    		sb.append(":");
    		sb.append(type);
    		sb.append(" & ");
    		sb.append(pattern);
    		sb.append(" = ");
    		sb.append(exp);

    		sb.append(" =>\nlet ");
    		sb.append(pattern);
    		sb.append(" = ");
    		sb.append(exp);
    		sb.append(" in");
		}

		return sb.toString();
	}
}
