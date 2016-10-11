package org.overture.signature;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.function.Consumer;

import org.overture.ast.analysis.AnalysisException;
import org.overture.ast.analysis.DepthFirstAnalysisAdaptor;
import org.overture.ast.definitions.AExplicitOperationDefinition;
import org.overture.ast.definitions.PDefinition;
import org.overture.ast.expressions.PExp;
import org.overture.ast.intf.lex.ILexLocation;
import org.overture.ast.intf.lex.ILexNameToken;
import org.overture.ast.lex.LexLocation;
import org.overture.ast.lex.LexNameToken;
import org.overture.ast.patterns.PPattern;
import org.overture.ast.statements.ACallStm;
import org.overture.ast.types.AOperationType;
import org.overture.ast.types.PType;

public class CallOccurrenceSignatureChanger extends DepthFirstAnalysisAdaptor {
	private ILexLocation defLoc;
	private Set<ACallStm> callOccurences;
	private Consumer<SignatureChangeObject> function;
	
	public CallOccurrenceSignatureChanger(ILexLocation defLoc, Consumer<SignatureChangeObject> f)
	{
		this.defLoc = defLoc;
		this.callOccurences = new HashSet<ACallStm>();
		this.function = f;
	}

	public Set<ACallStm> getCalls()
	{
		return callOccurences;
	}
	
	@Override
	public void caseACallStm(ACallStm node) throws AnalysisException {
		AExplicitOperationDefinition root = (AExplicitOperationDefinition) node.getRootdef();
		
		if (root == null)
		{
			return;
		}

		if (root.getLocation().equals(defLoc))
		{
			LinkedList<PPattern> patterns = ((AExplicitOperationDefinition) root).getParameterPatterns();
			String newParamNameStr = patterns.getLast().toString();
			
			AExplicitOperationDefinition parent = (AExplicitOperationDefinition)node.parent();
			LinkedList<PExp> paramListOfParent = node.getArgs();
			ILexLocation lastLoc = paramListOfParent.getLast().getLocation();
			LexLocation newLastLoc = new LexLocation(lastLoc.getFile(),lastLoc.getModule(),lastLoc.getStartLine(),lastLoc.getEndPos()+2,lastLoc.getEndLine(),lastLoc.getEndPos()+2+String.valueOf(newParamNameStr).length(),lastLoc.getStartOffset(), lastLoc.getEndOffset());
			
			ILexNameToken newParamName = new LexNameToken(root.getName().getModule(), newParamNameStr, newLastLoc);				
			
			function.accept(new SignatureChangeObject(newParamName.getLocation(), newParamName, paramListOfParent ,parent.getName().getName()));
		
			callOccurences.add(node);
		}
	}
}
