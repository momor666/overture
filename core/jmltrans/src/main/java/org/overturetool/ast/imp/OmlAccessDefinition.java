//
// THIS FILE IS AUTOMATICALLY GENERATED!!
//
// Generated at Wed 11-Jun-2008 by the VDM++ to JAVA Code Generator
// (v8.0.1b - Mon 28-Jan-2008 10:17:36)
//
// Supported compilers:
// jdk1.4
//

// ***** VDMTOOLS START Name=HeaderComment KEEP=NO
// ***** VDMTOOLS END Name=HeaderComment

// ***** VDMTOOLS START Name=package KEEP=NO
package org.overturetool.ast.imp;

// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=YES

import jp.co.csk.vdm.toolbox.VDM.*;

import java.util.*;
import org.overturetool.ast.itf.*;
@SuppressWarnings(all) 
// ***** VDMTOOLS END Name=imports



public class OmlAccessDefinition extends OmlNode implements IOmlAccessDefinition {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=ivAsyncAccess KEEP=NO
  private Boolean ivAsyncAccess = null;
// ***** VDMTOOLS END Name=ivAsyncAccess

// ***** VDMTOOLS START Name=ivStaticAccess KEEP=NO
  private Boolean ivStaticAccess = null;
// ***** VDMTOOLS END Name=ivStaticAccess

// ***** VDMTOOLS START Name=ivScope KEEP=NO
  private IOmlScope ivScope = null;
// ***** VDMTOOLS END Name=ivScope


// ***** VDMTOOLS START Name=OmlAccessDefinition KEEP=NO
  public OmlAccessDefinition () throws CGException {
    try {

      ivAsyncAccess = null;
      ivStaticAccess = null;
      ivScope = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=OmlAccessDefinition


// ***** VDMTOOLS START Name=identity KEEP=NO
  public String identity () throws CGException {
    return new String("AccessDefinition");
  }
// ***** VDMTOOLS END Name=identity


// ***** VDMTOOLS START Name=accept KEEP=NO
  public void accept (final IOmlVisitor pVisitor) throws CGException {
    pVisitor.visitAccessDefinition((IOmlAccessDefinition) this);
  }
// ***** VDMTOOLS END Name=accept


// ***** VDMTOOLS START Name=OmlAccessDefinition KEEP=NO
  public OmlAccessDefinition (final Boolean p1, final Boolean p2, final IOmlScope p3) throws CGException {

    try {

      ivAsyncAccess = null;
      ivStaticAccess = null;
      ivScope = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setAsyncAccess(p1);
      setStaticAccess(p2);
      setScope((IOmlScope) p3);
    }
  }
// ***** VDMTOOLS END Name=OmlAccessDefinition


// ***** VDMTOOLS START Name=OmlAccessDefinition KEEP=NO
  public OmlAccessDefinition (final Boolean p1, final Boolean p2, final IOmlScope p3, final Long line, final Long column) throws CGException {

    try {

      ivAsyncAccess = null;
      ivStaticAccess = null;
      ivScope = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setAsyncAccess(p1);
      setStaticAccess(p2);
      setScope((IOmlScope) p3);
      setPosition(line, column);
    }
  }
// ***** VDMTOOLS END Name=OmlAccessDefinition


// ***** VDMTOOLS START Name=init KEEP=NO
  public void init (final HashMap data) throws CGException {

    {

      String fname = new String("async_access");
      Boolean cond_4 = null;
      cond_4 = new Boolean(data.containsKey(fname));
      if (cond_4.booleanValue()) 
        setAsyncAccess((Boolean) data.get(fname));
    }
    {

      String fname = new String("static_access");
      Boolean cond_13 = null;
      cond_13 = new Boolean(data.containsKey(fname));
      if (cond_13.booleanValue()) 
        setStaticAccess((Boolean) data.get(fname));
    }
    {

      String fname = new String("scope");
      Boolean cond_22 = null;
      cond_22 = new Boolean(data.containsKey(fname));
      if (cond_22.booleanValue()) 
        setScope((IOmlScope) data.get(fname));
    }
  }
// ***** VDMTOOLS END Name=init


// ***** VDMTOOLS START Name=getAsyncAccess KEEP=NO
  public Boolean getAsyncAccess () throws CGException {
    return ivAsyncAccess;
  }
// ***** VDMTOOLS END Name=getAsyncAccess


// ***** VDMTOOLS START Name=setAsyncAccess KEEP=NO
  public void setAsyncAccess (final Boolean parg) throws CGException {
    ivAsyncAccess = (Boolean) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setAsyncAccess


// ***** VDMTOOLS START Name=getStaticAccess KEEP=NO
  public Boolean getStaticAccess () throws CGException {
    return ivStaticAccess;
  }
// ***** VDMTOOLS END Name=getStaticAccess


// ***** VDMTOOLS START Name=setStaticAccess KEEP=NO
  public void setStaticAccess (final Boolean parg) throws CGException {
    ivStaticAccess = (Boolean) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setStaticAccess


// ***** VDMTOOLS START Name=getScope KEEP=NO
  public IOmlScope getScope () throws CGException {
    return (IOmlScope) ivScope;
  }
// ***** VDMTOOLS END Name=getScope


// ***** VDMTOOLS START Name=setScope KEEP=NO
  public void setScope (final IOmlScope parg) throws CGException {
    ivScope = (IOmlScope) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setScope
  
  public String toString() {

	  String sta = new String();
	  String assync = new String();
	  String scope = new String();
	  String res = new String();

	  if(this.ivAsyncAccess)
		  assync = "sync ";
	  if(this.ivStaticAccess)
		  sta = "static ";

	  int val = -1;
	  try {
		  val = this.ivScope.getValue().intValue();
	  } catch (CGException e) {
		  

		  e.printStackTrace();
	  } 

	  switch(val) {
	  case 0: scope = "protected "; break;
	  case 1: scope = "private "; break;
	  case 2: scope = "public "; break;
	  case 3: scope = ""; break;
	  default: scope = ""; break;
	  }

	  res = assync + sta + scope;
	  
	  return res;
  }

}
;
