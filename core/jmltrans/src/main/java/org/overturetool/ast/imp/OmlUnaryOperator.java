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



public class OmlUnaryOperator extends OmlNode implements IOmlUnaryOperator {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=val KEEP=NO
  private Long val = null;
// ***** VDMTOOLS END Name=val


// ***** VDMTOOLS START Name=OmlUnaryOperator KEEP=NO
  public OmlUnaryOperator () throws CGException {
    try {
      val = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=OmlUnaryOperator


// ***** VDMTOOLS START Name=identity KEEP=NO
  public String identity () throws CGException {
    return new String("UnaryOperator");
  }
// ***** VDMTOOLS END Name=identity


// ***** VDMTOOLS START Name=accept KEEP=NO
  public void accept (final IOmlVisitor pVisitor) throws CGException {
    pVisitor.visitUnaryOperator((IOmlUnaryOperator) this);
  }
// ***** VDMTOOLS END Name=accept


// ***** VDMTOOLS START Name=OmlUnaryOperator KEEP=NO
  public OmlUnaryOperator (final Long pv) throws CGException {

    try {
      val = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    setValue(pv);
  }
// ***** VDMTOOLS END Name=OmlUnaryOperator


// ***** VDMTOOLS START Name=OmlUnaryOperator KEEP=NO
  public OmlUnaryOperator (final Long pv, final Long pline, final Long pcolumn) throws CGException {

    try {
      val = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setValue(pv);
      setPosition(pline, pcolumn);
    }
  }
// ***** VDMTOOLS END Name=OmlUnaryOperator


// ***** VDMTOOLS START Name=setValue KEEP=NO
  public void setValue (final Long pval) throws CGException {
    val = UTIL.NumberToLong(UTIL.clone(pval));
  }
// ***** VDMTOOLS END Name=setValue


// ***** VDMTOOLS START Name=getValue KEEP=NO
  public Long getValue () throws CGException {
    return val;
  }
// ***** VDMTOOLS END Name=getValue


// ***** VDMTOOLS START Name=getStringValue KEEP=NO
  public String getStringValue () throws CGException {

    String rexpr_1 = null;
    rexpr_1 = OmlUnaryOperatorQuotes.getQuoteName(val);
    return rexpr_1;
  }
// ***** VDMTOOLS END Name=getStringValue

  public String toString() {
	  String res = new String();
	  try {
		res = getStringValue();
	} catch (CGException e) {
		

		e.printStackTrace();
	}
	return res;
  }
}
;
