package org.overture.typechecker.utilities;

import org.overture.ast.analysis.AnalysisException;
import org.overture.ast.analysis.QuestionAdaptor;
import org.overture.ast.definitions.AClassInvariantDefinition;
import org.overture.ast.definitions.AEqualsDefinition;
import org.overture.ast.definitions.AExplicitFunctionDefinition;
import org.overture.ast.definitions.AExplicitOperationDefinition;
import org.overture.ast.definitions.AImplicitFunctionDefinition;
import org.overture.ast.definitions.AImplicitOperationDefinition;
import org.overture.ast.definitions.AStateDefinition;
import org.overture.ast.definitions.ASystemClassDefinition;
import org.overture.ast.definitions.AThreadDefinition;
import org.overture.ast.definitions.ATypeDefinition;
import org.overture.ast.definitions.PDefinition;
import org.overture.ast.definitions.SClassDefinition;
import org.overture.typechecker.Environment;
import org.overture.typechecker.assistant.ITypeCheckerAssistantFactory;
import org.overture.typechecker.assistant.definition.AExplicitFunctionDefinitionAssistantTC;
import org.overture.typechecker.assistant.definition.AExplicitOperationDefinitionAssistantTC;
import org.overture.typechecker.assistant.definition.AImplicitFunctionDefinitionAssistantTC;
import org.overture.typechecker.assistant.definition.AImplicitOperationDefinitionAssistantTC;
import org.overture.typechecker.assistant.definition.AStateDefinitionAssistantTC;
import org.overture.typechecker.assistant.definition.ASystemClassDefinitionAssistantTC;
import org.overture.typechecker.assistant.definition.AThreadDefinitionAssistantTC;
import org.overture.typechecker.assistant.definition.ATypeDefinitionAssistantTC;
import org.overture.typechecker.assistant.definition.PDefinitionAssistantTC;
import org.overture.typechecker.assistant.definition.SClassDefinitionAssistantTC;

/**
 * This class implements a way to find ImplicitDefinitions from nodes from the AST.
 * 
 * @author kel
 */
public class ImplicitDefinitionFinder extends QuestionAdaptor<Environment>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5570219609306178637L;
	
	protected ITypeCheckerAssistantFactory af;

	public ImplicitDefinitionFinder(ITypeCheckerAssistantFactory af)
	{
		this.af = af;
	}
	
	@Override
	public void defaultSClassDefinition(SClassDefinition node,
			Environment question) throws AnalysisException
	{
		//TODO: should I expand this even more?
		if (node instanceof ASystemClassDefinition)
		{
			ASystemClassDefinitionAssistantTC.implicitDefinitions((ASystemClassDefinition)node, question);
		} else
		{
			SClassDefinitionAssistantTC.implicitDefinitionsBase(node, question);
		}
	}
	
	@Override
	public void caseAClassInvariantDefinition(AClassInvariantDefinition node,
				Environment question) throws AnalysisException
	{
			
	}
	
	@Override
	public void caseAEqualsDefinition(AEqualsDefinition node,
			Environment question) throws AnalysisException
	{
		
	}
	
	@Override
	public void caseAExplicitFunctionDefinition(
			AExplicitFunctionDefinition node, Environment question)
			throws AnalysisException
	{
		if (node.getPrecondition() != null)
		{
			node.setPredef(AExplicitFunctionDefinitionAssistantTC.getPreDefinition(node));
			//PDefinitionAssistantTC.markUsed(d.getPredef());//ORIGINAL CODE
			af.getUsedMarker().caseAExplicitFunctionDefinition(node.getPredef());
		} else
		{
			node.setPredef(null);
		}

		if (node.getPostcondition() != null)
		{
			node.setPostdef(AExplicitFunctionDefinitionAssistantTC.getPostDefinition(node));
			//PDefinitionAssistantTC.markUsed(d.getPostdef());//ORIGINAL CODE
			af.getUsedMarker().caseAExplicitFunctionDefinition(node.getPostdef());
		} else
		{
			node.setPostdef(null);
		}
	}
	

	@Override
	public void caseAExplicitOperationDefinition(
			AExplicitOperationDefinition node, Environment question)
			throws AnalysisException
	{
		node.setState(question.findStateDefinition());

		if (node.getPrecondition() != null)
		{
			node.setPredef(AExplicitOperationDefinitionAssistantTC.getPreDefinition(node, question));
			PDefinitionAssistantTC.markUsed(node.getPredef()); //ORIGINAL CODE
			
			//af.getUsedMarker().caseAExplicitOperationDefinition((AExplicitOperationDefinition)node.getPredef());
		}

		if (node.getPostcondition() != null)
		{
			node.setPostdef(AExplicitOperationDefinitionAssistantTC.getPostDefinition(node, question));
			PDefinitionAssistantTC.markUsed(node.getPostdef());
		}
	}

	@Override
	public void caseAImplicitFunctionDefinition(
			AImplicitFunctionDefinition node, Environment question)
			throws AnalysisException
	{
		
		if (node.getPrecondition() != null)
		{
			node.setPredef(AImplicitFunctionDefinitionAssistantTC.getPreDefinition(node));
			PDefinitionAssistantTC.markUsed(node.getPredef());
		} else
		{
			node.setPredef(null);
		}

		if (node.getPostcondition() != null)
		{
			node.setPostdef(AImplicitFunctionDefinitionAssistantTC.getPostDefinition(node));
			PDefinitionAssistantTC.markUsed(node.getPostdef());
		} else
		{
			node.setPostdef(null);
		}
	}
	@Override
	public void caseAImplicitOperationDefinition(
			AImplicitOperationDefinition node, Environment question)
			throws AnalysisException
	{
		node.setState(question.findStateDefinition());

		if (node.getPrecondition() != null)
		{
			node.setPredef(AImplicitOperationDefinitionAssistantTC.getPreDefinition(node, question));
			PDefinitionAssistantTC.markUsed(node.getPredef());
		}

		if (node.getPostcondition() != null)
		{
			node.setPostdef(AImplicitOperationDefinitionAssistantTC.getPostDefinition(node, question));
			PDefinitionAssistantTC.markUsed(node.getPostdef());
		}
	}
	@Override
	public void caseAStateDefinition(AStateDefinition node, Environment question)
			throws AnalysisException
	{
		if (node.getInvPattern() != null)
		{
			node.setInvdef(AStateDefinitionAssistantTC.getInvDefinition(node));
		}

		if (node.getInitPattern() != null)
		{
			node.setInitdef(AStateDefinitionAssistantTC.getInitDefinition(node));
		}
	}
	@Override
	public void caseAThreadDefinition(AThreadDefinition node,
			Environment question) throws AnalysisException
	{
		//ORIGINAL CODE FROM ASSISTANT
		//node.setOperationDef(AThreadDefinitionAssistantTC.getThreadDefinition(node)); 
		//Mine non static call of the code.
		node.setOperationDef(af.createAThreadDefinitionAssistant().getThreadDefinition(node));
	}	
	@Override
	public void caseATypeDefinition(ATypeDefinition node, Environment question)
			throws AnalysisException
	{		
		if (node.getInvPattern() != null)
		{
			//node.setInvdef(getInvDefinition(d)); //Original code from Assistant.
			node.setInvdef(af.createATypeDefinitionAssistant().getInvDefinition(node));
			node.getInvType().setInvDef(node.getInvdef());
		} else
		{
			node.setInvdef(null);
		}
	}
	@Override
	public void defaultPDefinition(PDefinition node, Environment question)
			throws AnalysisException
	{
		return ;
	}
	
	
}
