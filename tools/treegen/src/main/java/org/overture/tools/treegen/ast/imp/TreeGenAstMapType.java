// this file is automatically generated by treegen. do not modify!

package org.overture.tools.treegen.ast.imp;

// import the abstract tree interfaces
import org.overture.tools.treegen.ast.itf.*;

public class TreeGenAstMapType extends TreeGenAstTypeSpecification implements ITreeGenAstMapType
{
	// private member variable (dom_type)
	private ITreeGenAstTypeSpecification m_dom_type = null;

	// public operation to retrieve the embedded private field value
	public ITreeGenAstTypeSpecification getDomType()
	{
		return m_dom_type;
	}

	// public operation to set the embedded private field value
	public void setDomType(ITreeGenAstTypeSpecification p_dom_type)
	{
		// consistency check (field must be non null!)
		assert(p_dom_type != null);

		// instantiate the member variable
		m_dom_type = p_dom_type;
	}

	// private member variable (rng_type)
	private ITreeGenAstTypeSpecification m_rng_type = null;

	// public operation to retrieve the embedded private field value
	public ITreeGenAstTypeSpecification getRngType()
	{
		return m_rng_type;
	}

	// public operation to set the embedded private field value
	public void setRngType(ITreeGenAstTypeSpecification p_rng_type)
	{
		// consistency check (field must be non null!)
		assert(p_rng_type != null);

		// instantiate the member variable
		m_rng_type = p_rng_type;
	}

	// default constructor
	public TreeGenAstMapType()
	{
		super();
		m_dom_type = null;
		m_rng_type = null;
	}

	// visitor support
	public void accept(ITreeGenAstVisitor pVisitor) { pVisitor.visitMapType(this); }

	// the identity function
	public String identify() { return "TreeGenAstMapType"; }
}
