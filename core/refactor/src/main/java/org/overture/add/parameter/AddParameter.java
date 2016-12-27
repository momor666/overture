package org.overture.add.parameter;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.overture.ast.analysis.AnalysisException;
import org.overture.ast.definitions.PDefinition;
import org.overture.ast.node.INode;
import org.overture.ast.statements.AIdentifierStateDesignator;
import org.overture.typechecker.assistant.ITypeCheckerAssistantFactory;

public class AddParameter {
	public Set<AddParameterRefactoring> computeSignatures(List<? extends INode> nodes,
			ITypeCheckerAssistantFactory af,
			Map<AIdentifierStateDesignator, PDefinition> idDefs)
			throws AnalysisException
	{
		RefactoringAddParameterCollector signatureChangeCollector = new RefactoringAddParameterCollector(af, idDefs);

		for (INode node : nodes)
		{
			node.apply(signatureChangeCollector);
			signatureChangeCollector.init(false);
		}

		return signatureChangeCollector.getSignatureChanges();
	}
	
	public Set<AddParameterRefactoring> computeSignatureChanges(INode node,
			RefactoringAddParameterCollector collector) throws AnalysisException
	{
		collector.init(true);
		node.apply(collector);

		return collector.getSignatureChanges();
	}
}