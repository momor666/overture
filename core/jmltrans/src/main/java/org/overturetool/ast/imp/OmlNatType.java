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



public class OmlNatType extends OmlType implements IOmlNatType {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp


// ***** VDMTOOLS START Name=identity KEEP=NO
  public String identity () throws CGException {
    return new String("NatType");
  }
// ***** VDMTOOLS END Name=identity


// ***** VDMTOOLS START Name=accept KEEP=NO
  public void accept (final IOmlVisitor pVisitor) throws CGException {
    pVisitor.visitNatType((IOmlNatType) this);
  }
// ***** VDMTOOLS END Name=accept


// ***** VDMTOOLS START Name=OmlNatType KEEP=NO
  public OmlNatType () throws CGException {}
// ***** VDMTOOLS END Name=OmlNatType


// ***** VDMTOOLS START Name=OmlNatType KEEP=NO
  public OmlNatType (final Long line, final Long column) throws CGException {
    setPosition(line, column);
  }
// ***** VDMTOOLS END Name=OmlNatType


// ***** VDMTOOLS START Name=init KEEP=NO
  public void init (final HashMap var_1_1) throws CGException {}
// ***** VDMTOOLS END Name=init

  public String toString() {
	  return "nat";
  }
}
;
