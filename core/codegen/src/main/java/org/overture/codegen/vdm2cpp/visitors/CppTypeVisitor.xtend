package org.overture.codegen.vdm2cpp.visitors

import org.overture.codegen.cgast.INode
import org.overture.codegen.cgast.STypeCGBase
import org.overture.codegen.cgast.analysis.AnalysisException
import org.overture.codegen.cgast.declarations.AClassDeclCG
import org.overture.codegen.cgast.types.ABoolBasicTypeCG
import org.overture.codegen.cgast.types.ACharBasicTypeCG
import org.overture.codegen.cgast.types.AClassTypeCG
import org.overture.codegen.cgast.types.AIntNumericBasicTypeCG
import org.overture.codegen.cgast.types.AMapMapTypeCG
import org.overture.codegen.cgast.types.AMethodTypeCG
import org.overture.codegen.cgast.types.ANat1NumericBasicTypeCG
import org.overture.codegen.cgast.types.ANatNumericBasicTypeCG
import org.overture.codegen.cgast.types.ARealBasicTypeWrappersTypeCG
import org.overture.codegen.cgast.types.ARealNumericBasicTypeCG
import org.overture.codegen.cgast.types.ARecordTypeCG
import org.overture.codegen.cgast.types.ASeqSeqTypeCG
import org.overture.codegen.cgast.types.ASetSetTypeCG
import org.overture.codegen.cgast.types.AStringTypeCG
import org.overture.codegen.cgast.types.ATupleTypeCG
import org.overture.codegen.cgast.types.AUnionTypeCG
import org.overture.codegen.cgast.types.AUnknownTypeCG
import org.overture.codegen.cgast.types.AVoidTypeCG
import org.overture.codegen.vdm2cpp.XtendAnswerStringVisitor

class CppTypeVisitor extends XtendAnswerStringVisitor{
		XtendAnswerStringVisitor root_generator;
	
	new(XtendAnswerStringVisitor root) {
		root_generator = root
	}

	override defaultINode(INode node) throws AnalysisException {
		
		if( node instanceof STypeCGBase )
		{
			System.out.println("unhandled type node: " + node.getClass.toString() )
			System.out.println( (node as STypeCGBase).tag)
			System.out.println("In Class: " + node.getAncestor(AClassDeclCG).name)
			return '''/*unhandled type*/'''
		}
		else
		{
			return node.apply(root_generator)
		}
	}
	
	def expand(INode node)
	{
		return node.apply(root_generator);
	}
	
	override caseAVoidTypeCG(AVoidTypeCG node )
	'''void'''
	
	override caseAMethodTypeCG(AMethodTypeCG node )
	'''«node.result.expand»'''
	
	override caseATupleTypeCG(ATupleTypeCG node )
	'''std::tuple<«FOR type: node.types SEPARATOR ","»«type.expand» «ENDFOR»>'''
	
	override caseANatNumericBasicTypeCG(ANatNumericBasicTypeCG node )
	'''int'''
	
	override caseAUnknownTypeCG(AUnknownTypeCG node )
	'''boost::any'''
	
	override caseASeqSeqTypeCG(ASeqSeqTypeCG node )
	'''vdm::sequence'''
	
	override caseARecordTypeCG(ARecordTypeCG node )
	'''«node.name.expand»'''
	
	override caseASetSetTypeCG(ASetSetTypeCG node ) 
	''' vdm::set'''

	override caseAMapMapTypeCG(AMapMapTypeCG node )		
	'''vdm::map<«node.from.expand», «node.to.expand»>'''

	
	override caseAClassTypeCG(AClassTypeCG node )
	'''std::shared_ptr<«node.name»>'''
	
	override caseAUnionTypeCG(AUnionTypeCG node )
	'''«node.types.first.expand»'''
		
	override caseACharBasicTypeCG(ACharBasicTypeCG node )
	'''char'''
	
	override caseARealNumericBasicTypeCG(ARealNumericBasicTypeCG node )
	'''double'''
	
	override caseARealBasicTypeWrappersTypeCG(ARealBasicTypeWrappersTypeCG node )
	'''double'''
	
	override caseAIntNumericBasicTypeCG(AIntNumericBasicTypeCG node )
	'''int'''
	
	override caseABoolBasicTypeCG(ABoolBasicTypeCG node )
	'''bool'''
	
	override caseAStringTypeCG(AStringTypeCG node )
	'''std::string'''
	
	override caseANat1NumericBasicTypeCG(ANat1NumericBasicTypeCG node )
	'''double'''
}