package org.overture.codegen.utils;

import java.util.LinkedList;
import java.util.List;

import org.overture.ast.analysis.AnalysisException;
import org.overture.ast.node.INode;

public class VdmAstAnalysis
{

	public static List<Violation> usesIllegalNames(List<? extends INode> nodes, NamingComparison comparison) throws AnalysisException
	{
		List<Violation> allIllegals = new LinkedList<Violation>();
		
		for (INode currentNode : nodes)
		{
			List<Violation> currentIllegals = usesIllegalName(currentNode, comparison);
			
			if(!currentIllegals.isEmpty())
				allIllegals.addAll(currentIllegals);
		}
		
		return allIllegals;
	}
	
	public static List<Violation> usesIllegalName(INode node, NamingComparison comparison) throws AnalysisException
	{
		NameViolationAnalysis nameAnalysis = new NameViolationAnalysis(comparison);
		try
		{
			node.apply(nameAnalysis);
		} catch (AnalysisException e)
		{
			throw e;
		}

		return nameAnalysis.getNameViolations();
	}
}