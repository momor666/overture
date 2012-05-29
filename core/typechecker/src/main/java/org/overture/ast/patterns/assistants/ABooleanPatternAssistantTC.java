package org.overture.ast.patterns.assistants;

import org.overture.ast.expressions.ABooleanConstExp;
import org.overture.ast.expressions.PExp;
import org.overture.ast.factory.AstFactory;
import org.overture.ast.patterns.ABooleanPattern;
import org.overture.ast.types.PType;
import org.overturetool.vdmj.lex.LexBooleanToken;

public class ABooleanPatternAssistantTC {

	public static PType getPossibleType(ABooleanPattern pattern) {
		return AstFactory.newABooleanBasicType(pattern.getLocation());
	}

	public static PExp getMatchingExpression(ABooleanPattern bp) {
		LexBooleanToken tok = bp.getValue();
		ABooleanConstExp res = AstFactory.newABooleanConstExp((LexBooleanToken) tok.clone());
		return res;
	}

}
