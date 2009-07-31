// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 31-07-2009 16:18:23
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   OmlOpRequest.java

package org.overturetool.traceviewer.ast.imp;

import java.util.HashMap;

import jp.co.csk.vdm.toolbox.VDM.CGException;
import jp.co.csk.vdm.toolbox.VDM.UTIL;

import org.overturetool.traceviewer.ast.itf.IOmlOpRequest;
import org.overturetool.traceviewer.ast.itf.IOmlVisitor;

// Referenced classes of package org.overturetool.tracefile.ast.imp:
//            OmlTraceEvent

public class OmlOpRequest extends OmlTraceEvent
    implements IOmlOpRequest
{

    public OmlOpRequest()
        throws CGException
    {
        ivId = null;
        ivOpname = null;
        ivObjref = null;
        ivClnm = null;
        ivCpunm = null;
        ivAsynchronous = null;
        ivArgs = null;
        ivObstime = null;
        try
        {
            ivId = null;
            ivOpname = UTIL.ConvertToString(new String());
            ivObjref = null;
            ivClnm = UTIL.ConvertToString(new String());
            ivCpunm = null;
            ivAsynchronous = null;
            ivArgs = null;
            ivObstime = null;
        }
        catch(Exception e)
        {
            e.printStackTrace(System.out);
            System.out.println(e.getMessage());
        }
    }

    @Override
	public String identity()
        throws CGException
    {
        return new String("OpRequest");
    }

    @Override
	public void accept(IOmlVisitor pVisitor)
        throws CGException
    {
        pVisitor.visitOpRequest(this);
    }

    public OmlOpRequest(Long p1, String p2, Long p3, String p4, Long p5, Boolean p6, String p7, 
            Long p8)
        throws CGException
    {
        this();
        setId(p1);
        setOpname(p2);
        setObjref(p3);
        setClnm(p4);
        setCpunm(p5);
        setAsynchronous(p6);
        setArgs(p7);
        setObstime(p8);
    }

    public void init(HashMap data)
        throws CGException
    {
        String fname = new String("id");
        Boolean cond_4 = null;
        cond_4 = new Boolean(data.containsKey(fname));
        if(cond_4.booleanValue())
            setId(UTIL.NumberToLong(data.get(fname)));
        fname = new String("opname");
        Boolean cond_13 = null;
        cond_13 = new Boolean(data.containsKey(fname));
        if(cond_13.booleanValue())
            setOpname(UTIL.ConvertToString(data.get(fname)));
        fname = new String("objref");
        Boolean cond_22 = null;
        cond_22 = new Boolean(data.containsKey(fname));
        if(cond_22.booleanValue())
            setObjref(UTIL.NumberToLong(data.get(fname)));
        fname = new String("clnm");
        Boolean cond_31 = null;
        cond_31 = new Boolean(data.containsKey(fname));
        if(cond_31.booleanValue())
            setClnm(UTIL.ConvertToString(data.get(fname)));
        fname = new String("cpunm");
        Boolean cond_40 = null;
        cond_40 = new Boolean(data.containsKey(fname));
        if(cond_40.booleanValue())
            setCpunm(UTIL.NumberToLong(data.get(fname)));
        fname = new String("async");
        Boolean cond_49 = null;
        cond_49 = new Boolean(data.containsKey(fname));
        if(cond_49.booleanValue())
            setAsynchronous((Boolean)data.get(fname));
        fname = new String("args");
        Boolean cond_58 = null;
        cond_58 = new Boolean(data.containsKey(fname));
        if(cond_58.booleanValue())
            setArgs(UTIL.ConvertToString(data.get(fname)));
        fname = new String("time");
        Boolean cond_67 = null;
        cond_67 = new Boolean(data.containsKey(fname));
        if(cond_67.booleanValue())
            setObstime(UTIL.NumberToLong(data.get(fname)));
    }

    public Long getId()
        throws CGException
    {
        return ivId;
    }

    public void setId(Long parg)
        throws CGException
    {
        ivId = UTIL.NumberToLong(UTIL.clone(parg));
    }

    public String getOpname()
        throws CGException
    {
        return ivOpname;
    }

    public void setOpname(String parg)
        throws CGException
    {
        ivOpname = UTIL.ConvertToString(UTIL.clone(parg));
    }

    public Long getObjref()
        throws CGException
    {
        if(!pre_getObjref().booleanValue())
            UTIL.RunTime("Run-Time Error:Precondition failure in getObjref");
        return ivObjref;
    }

    public Boolean pre_getObjref()
        throws CGException
    {
        return hasObjref();
    }

    public Boolean hasObjref()
        throws CGException
    {
        return new Boolean(!UTIL.equals(ivObjref, null));
    }

    public void setObjref(Long parg)
        throws CGException
    {
        ivObjref = UTIL.NumberToLong(UTIL.clone(parg));
    }

    public String getClnm()
        throws CGException
    {
        return ivClnm;
    }

    public void setClnm(String parg)
        throws CGException
    {
        ivClnm = UTIL.ConvertToString(UTIL.clone(parg));
    }

    public Long getCpunm()
        throws CGException
    {
        return ivCpunm;
    }

    public void setCpunm(Long parg)
        throws CGException
    {
        ivCpunm = UTIL.NumberToLong(UTIL.clone(parg));
    }

    public Boolean getAsynchronous()
        throws CGException
    {
        return ivAsynchronous;
    }

    public void setAsynchronous(Boolean parg)
        throws CGException
    {
        ivAsynchronous = (Boolean)UTIL.clone(parg);
    }

    public String getArgs()
        throws CGException
    {
        if(!pre_getArgs().booleanValue())
            UTIL.RunTime("Run-Time Error:Precondition failure in getArgs");
        return ivArgs;
    }

    public Boolean pre_getArgs()
        throws CGException
    {
        return hasArgs();
    }

    public Boolean hasArgs()
        throws CGException
    {
        return new Boolean(!UTIL.equals(ivArgs, null));
    }

    public void setArgs(String parg)
        throws CGException
    {
        ivArgs = UTIL.ConvertToString(UTIL.clone(parg));
    }

    public Long getObstime()
        throws CGException
    {
        return ivObstime;
    }

    public void setObstime(Long parg)
        throws CGException
    {
        ivObstime = UTIL.NumberToLong(UTIL.clone(parg));
    }

    static jp.co.csk.vdm.toolbox.VDM.UTIL.VDMCompare vdmComp = new jp.co.csk.vdm.toolbox.VDM.UTIL.VDMCompare();
    private Long ivId;
    private String ivOpname;
    private Long ivObjref;
    private String ivClnm;
    private Long ivCpunm;
    private Boolean ivAsynchronous;
    private String ivArgs;
    private Long ivObstime;

}