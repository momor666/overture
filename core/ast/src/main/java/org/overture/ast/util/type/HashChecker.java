package org.overture.ast.util.type;

import org.overture.ast.analysis.AnalysisException;
import org.overture.ast.analysis.AnswerAdaptor;
import org.overture.ast.assistant.IAstAssistantFactory;
import org.overture.ast.node.INode;
import org.overture.ast.types.ABracketType;
import org.overture.ast.types.AClassType;
import org.overture.ast.types.AFunctionType;
import org.overture.ast.types.ANamedInvariantType;
import org.overture.ast.types.AOperationType;
import org.overture.ast.types.AOptionalType;
import org.overture.ast.types.AParameterType;
import org.overture.ast.types.AProductType;
import org.overture.ast.types.AQuoteType;
import org.overture.ast.types.ARecordInvariantType;
import org.overture.ast.types.ASetType;
import org.overture.ast.types.AUnionType;
import org.overture.ast.types.AUnresolvedType;
import org.overture.ast.types.PType;
import org.overture.ast.types.SInvariantType;
import org.overture.ast.types.SMapType;
import org.overture.ast.types.SSeqType;
/**
 * Used to check if a given type is having a hash.
 * 
 * @author gkanos
 */
public class HashChecker extends AnswerAdaptor<Integer>
{
	protected static IAstAssistantFactory af;

	@SuppressWarnings("static-access")
	public HashChecker(IAstAssistantFactory af)
	{
		this.af = af;
	}
	
	@Override
	public Integer caseABracketType(ABracketType type) throws AnalysisException
	{
		//return af.createPTypeAssistant().hashCode(type.getType());
		return type.apply(THIS);
	}
	
	@Override
	public Integer caseAClassType(AClassType type) throws AnalysisException
	{
		return type.getName().apply(THIS);
	}
	
	@Override
	public Integer caseAFunctionType(AFunctionType type)
			throws AnalysisException
	{
		AFunctionType ftype = type;
		return af.createPTypeAssistant().hashCode(ftype.getParameters()) + af.createPTypeAssistant().hashCode(ftype.getResult());
	//	return hashCode(ftype.getParameters())
	//			+ hashCode(ftype.getResult());
	//		AFunctionType ftype = (AFunctionType) type;
	//		return hashCode(ftype.getParameters())
	//				+ hashCode(ftype.getResult());
	}
	
	@Override
	public Integer caseANamedInvariantType(ANamedInvariantType type)
			throws AnalysisException
	{
		return type.getName().apply(THIS);
	}
	
	@Override
	public Integer caseARecordInvariantType(ARecordInvariantType type)
			throws AnalysisException
	{
		//return ((ARecordInvariantType) type).getName().hashCode();
		return type.getName().apply(THIS);
	}

	@Override
	public Integer defaultSInvariantType(SInvariantType type)
			throws AnalysisException
	{
		return type.getClass().hashCode();
	}
	
	@Override
	public Integer defaultSMapType(SMapType type) throws AnalysisException
	{
		SMapType mtype = type;
		return mtype.getFrom().apply(THIS) + mtype.getTo().apply(THIS);
	//	return hashCode(mtype.getFrom()) + hashCode(mtype.getTo());
	}
	
	@Override
	public Integer caseAOperationType(AOperationType type)
			throws AnalysisException
	{
		AOperationType otype = type;
		return af.createPTypeAssistant().hashCode(otype.getParameters()) + af.createPTypeAssistant().hashCode(otype.getResult());
		//return hashCode(otype.getParameters()) + hashCode(otype.getResult());
	}
	
	@Override
	public Integer caseAOptionalType(AOptionalType type)
			throws AnalysisException
	{
		return type.getType().apply(THIS);
		//return hashCode(((AOptionalType) type).getType());
	}
	
	@Override
	public Integer caseAParameterType(AParameterType type)
			throws AnalysisException
	{
		return type.getName().apply(THIS);
		//return ((AParameterType) type).getName().hashCode();
	}
	
	@Override
	public Integer caseAProductType(AProductType type) throws AnalysisException
	{
		//return type.getTypes().apply(THIS);
		return af.createPTypeAssistant().hashCode(type.getTypes());
	}
	
	@Override
	public Integer caseAQuoteType(AQuoteType type) throws AnalysisException
	{
		return type.getValue().hashCode();
	}
	
	@Override
	public Integer defaultSSeqType(SSeqType type) throws AnalysisException
	{
		SSeqType stype = type;
		return stype.getEmpty() ? 0 : stype.getSeqof().apply(THIS); //hashCode(stype.getSeqof());
	}
	
	@Override
	public Integer caseASetType(ASetType type) throws AnalysisException
	{
		ASetType stype = type;
		return stype.getEmpty() ? 0 : stype.getSetof().apply(THIS); //hashCode(stype.getSetof());
	}
	
	@Override
	public Integer caseAUnionType(AUnionType type) throws AnalysisException
	{
		AUnionType utype = type;
		return af.createPTypeAssistant().hashCode(utype.getTypes());
	}
	
	@Override
	public Integer caseAUnresolvedType(AUnresolvedType type)
			throws AnalysisException
	{
		return type.getName().hashCode();
	}
	
	@Override
	public Integer defaultPType(PType type) throws AnalysisException
	{
		return type.getClass().hashCode();
	}
//	} else if (type instanceof SInvariantType) {
//		if (type instanceof ANamedInvariantType) {
//			return ((ANamedInvariantType) type).getName().hashCode();
//		} else if (type instanceof ARecordInvariantType) {
//			
//		}
//	} else if (type instanceof SMapType) {
//		
//	} else if (type instanceof AOperationType) {
//		
//	} else if (type instanceof AOptionalType) {
//		
//	} else if (type instanceof AParameterType) {
//		
//	} else if (type instanceof AProductType) {
//		
//	} else if (type instanceof AQuoteType) {
//		
//	} else if (type instanceof SSeqType) {
//		
//		
//	} else if (type instanceof ASetType) {
//		
//		
//	} else if (type instanceof AUnionType) {
//		
//		
//	} else if (type instanceof AUnresolvedType) {
//		
//	}
//	

	@Override
	public Integer createNewReturnValue(INode type) throws AnalysisException
	{
		// TODO Auto-generated method stub
		return type.getClass().hashCode();
	}

	@Override
	public Integer createNewReturnValue(Object type) throws AnalysisException
	{
		// TODO Auto-generated method stub
		return type.getClass().hashCode();
	}
}
