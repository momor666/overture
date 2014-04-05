package org.overture.interpreter.utilities.definition;

import org.overture.ast.analysis.AnalysisException;
import org.overture.ast.analysis.AnswerAdaptor;
import org.overture.ast.definitions.AImportedDefinition;
import org.overture.ast.definitions.AInheritedDefinition;
import org.overture.ast.definitions.ARenamedDefinition;
import org.overture.ast.definitions.ATypeDefinition;
import org.overture.ast.definitions.PDefinition;
import org.overture.ast.node.INode;
import org.overture.interpreter.assistant.IInterpreterAssistantFactory;

	/***************************************
	 * 
	 * This method checks if a definition can be executed at runtime. 
	 * 
	 * @author gkanos
	 *
	 ****************************************/
public class DefinitionRunTimeChecker extends AnswerAdaptor<Boolean>
{
	protected IInterpreterAssistantFactory af;
	
	public DefinitionRunTimeChecker(IInterpreterAssistantFactory af)
	{
		this.af = af;
	}
	
	@Override
	public Boolean caseAImportedDefinition(AImportedDefinition def)
			throws AnalysisException
	{
		//return isRuntime(((AImportedDefinition) def).getDef());
		return def.getDef().apply(THIS);
	}
	
	@Override
	public Boolean caseAInheritedDefinition(AInheritedDefinition def)
			throws AnalysisException
	{
		//return isRuntime(((AInheritedDefinition) def).getSuperdef());
		return def.getSuperdef().apply(THIS);
	}
	
	@Override
	public Boolean caseARenamedDefinition(ARenamedDefinition def)
			throws AnalysisException
	{
		//return isRuntime(((ARenamedDefinition) def).getDef());
		return def.getDef().apply(THIS);
	}
	
	@Override
	public Boolean caseATypeDefinition(ATypeDefinition node)
			throws AnalysisException
	{
		return false;
	}
	
	@Override
	public Boolean defaultPDefinition(PDefinition node)
			throws AnalysisException
	{
		return true;
	}

	@Override
	public Boolean createNewReturnValue(INode node) throws AnalysisException
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean createNewReturnValue(Object node) throws AnalysisException
	{
		// TODO Auto-generated method stub
		return true;
	}

}
