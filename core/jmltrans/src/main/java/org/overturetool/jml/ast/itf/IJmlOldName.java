package org.overturetool.jml.ast.itf;

import jp.co.csk.vdm.toolbox.VDM.*;

public abstract interface IJmlOldName extends IJmlExpression
{
	abstract String getIdentifier() throws CGException;
}

