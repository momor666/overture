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



public class OmlCasesStatementAlternative extends OmlNode implements IOmlCasesStatementAlternative {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=ivPatternList KEEP=NO
  private Vector ivPatternList = null;
// ***** VDMTOOLS END Name=ivPatternList

// ***** VDMTOOLS START Name=ivStatement KEEP=NO
  private IOmlStatement ivStatement = null;
// ***** VDMTOOLS END Name=ivStatement


// ***** VDMTOOLS START Name=OmlCasesStatementAlternative KEEP=NO
  public OmlCasesStatementAlternative () throws CGException {
    try {

      ivPatternList = new Vector();
      ivStatement = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=OmlCasesStatementAlternative


// ***** VDMTOOLS START Name=identity KEEP=NO
  public String identity () throws CGException {
    return new String("CasesStatementAlternative");
  }
// ***** VDMTOOLS END Name=identity


// ***** VDMTOOLS START Name=accept KEEP=NO
  public void accept (final IOmlVisitor pVisitor) throws CGException {
    pVisitor.visitCasesStatementAlternative((IOmlCasesStatementAlternative) this);
  }
// ***** VDMTOOLS END Name=accept


// ***** VDMTOOLS START Name=OmlCasesStatementAlternative KEEP=NO
  public OmlCasesStatementAlternative (final Vector p1, final IOmlStatement p2) throws CGException {

    try {

      ivPatternList = new Vector();
      ivStatement = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setPatternList(p1);
      setStatement((IOmlStatement) p2);
    }
  }
// ***** VDMTOOLS END Name=OmlCasesStatementAlternative


// ***** VDMTOOLS START Name=OmlCasesStatementAlternative KEEP=NO
  public OmlCasesStatementAlternative (final Vector p1, final IOmlStatement p2, final Long line, final Long column) throws CGException {

    try {

      ivPatternList = new Vector();
      ivStatement = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setPatternList(p1);
      setStatement((IOmlStatement) p2);
      setPosition(line, column);
    }
  }
// ***** VDMTOOLS END Name=OmlCasesStatementAlternative


// ***** VDMTOOLS START Name=init KEEP=NO
  public void init (final HashMap data) throws CGException {

    {

      String fname = new String("pattern_list");
      Boolean cond_4 = null;
      cond_4 = new Boolean(data.containsKey(fname));
      if (cond_4.booleanValue()) 
        setPatternList((Vector) data.get(fname));
    }
    {

      String fname = new String("statement");
      Boolean cond_13 = null;
      cond_13 = new Boolean(data.containsKey(fname));
      if (cond_13.booleanValue()) 
        setStatement((IOmlStatement) data.get(fname));
    }
  }
// ***** VDMTOOLS END Name=init


// ***** VDMTOOLS START Name=getPatternList KEEP=NO
  public Vector getPatternList () throws CGException {
    return ivPatternList;
  }
// ***** VDMTOOLS END Name=getPatternList


// ***** VDMTOOLS START Name=setPatternList KEEP=NO
  public void setPatternList (final Vector parg) throws CGException {
    ivPatternList = (Vector) UTIL.ConvertToList(UTIL.clone(parg));
  }
// ***** VDMTOOLS END Name=setPatternList


// ***** VDMTOOLS START Name=addPatternList KEEP=NO
  public void addPatternList (final IOmlNode parg) throws CGException {
    ivPatternList.add(parg);
  }
// ***** VDMTOOLS END Name=addPatternList


// ***** VDMTOOLS START Name=getStatement KEEP=NO
  public IOmlStatement getStatement () throws CGException {
    return (IOmlStatement) ivStatement;
  }
// ***** VDMTOOLS END Name=getStatement


// ***** VDMTOOLS START Name=setStatement KEEP=NO
  public void setStatement (final IOmlStatement parg) throws CGException {
    ivStatement = (IOmlStatement) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setStatement

  public String toString() {
	  
	  String pattern = new String();
	  int i, size = this.ivPatternList.size();
	  
	  if(size > 0) {
		  for(i=0; i<size-1; i++) {
			  pattern += this.ivPatternList.get(i).toString() + ", ";
		  }
		  pattern += this.ivPatternList.get(size-1).toString();
	  }
	  return pattern + " -> " + this.ivStatement.toString();
  }
}
;
