// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 31-07-2009 16:18:54
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   IOmlBUSdecl.java

package org.overturetool.traceviewer.ast.itf;

import java.util.HashSet;
import jp.co.csk.vdm.toolbox.VDM.CGException;

// Referenced classes of package org.overturetool.tracefile.ast.itf:
//            IOmlTraceEvent

public interface IOmlBUSdecl
    extends IOmlTraceEvent
{

    public abstract Long getId()
        throws CGException;

    public abstract String getName()
        throws CGException;

    public abstract HashSet getTopo()
        throws CGException;
}