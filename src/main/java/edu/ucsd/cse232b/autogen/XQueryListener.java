// Generated from XQuery.g4 by ANTLR 4.13.1

package edu.ucsd.cse232b.autogen;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryParser}.
 */
public interface XQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code CommaXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterCommaXq(XQueryParser.CommaXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CommaXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitCommaXq(XQueryParser.CommaXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterRpXq(XQueryParser.RpXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitRpXq(XQueryParser.RpXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterStringXq(XQueryParser.StringXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitStringXq(XQueryParser.StringXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code wsXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterWsXq(XQueryParser.WsXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code wsXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitWsXq(XQueryParser.WsXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParaXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterParaXq(XQueryParser.ParaXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParaXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitParaXq(XQueryParser.ParaXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ApXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterApXq(XQueryParser.ApXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ApXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitApXq(XQueryParser.ApXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterVarXq(XQueryParser.VarXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitVarXq(XQueryParser.VarXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LetXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterLetXq(XQueryParser.LetXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LetXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitLetXq(XQueryParser.LetXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterForXq(XQueryParser.ForXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitForXq(XQueryParser.ForXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterTagXq(XQueryParser.TagXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitTagXq(XQueryParser.TagXqContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(XQueryParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(XQueryParser.ForClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void enterLetClause(XQueryParser.LetClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void exitLetClause(XQueryParser.LetClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(XQueryParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(XQueryParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterReturnClause(XQueryParser.ReturnClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitReturnClause(XQueryParser.ReturnClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqCond2}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterEqCond2(XQueryParser.EqCond2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code EqCond2}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitEqCond2(XQueryParser.EqCond2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code ConjunctCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterConjunctCond(XQueryParser.ConjunctCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConjunctCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitConjunctCond(XQueryParser.ConjunctCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqCond1}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterEqCond1(XQueryParser.EqCond1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code EqCond1}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitEqCond1(XQueryParser.EqCond1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code SatCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterSatCond(XQueryParser.SatCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SatCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitSatCond(XQueryParser.SatCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterEmptyCond(XQueryParser.EmptyCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitEmptyCond(XQueryParser.EmptyCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterNegCond(XQueryParser.NegCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitNegCond(XQueryParser.NegCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParaCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterParaCond(XQueryParser.ParaCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParaCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitParaCond(XQueryParser.ParaCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IsCond1}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterIsCond1(XQueryParser.IsCond1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code IsCond1}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitIsCond1(XQueryParser.IsCond1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code IsCond2}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterIsCond2(XQueryParser.IsCond2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code IsCond2}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitIsCond2(XQueryParser.IsCond2Context ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#satisfy}.
	 * @param ctx the parse tree
	 */
	void enterSatisfy(XQueryParser.SatisfyContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#satisfy}.
	 * @param ctx the parse tree
	 */
	void exitSatisfy(XQueryParser.SatisfyContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#startTag}.
	 * @param ctx the parse tree
	 */
	void enterStartTag(XQueryParser.StartTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#startTag}.
	 * @param ctx the parse tree
	 */
	void exitStartTag(XQueryParser.StartTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#endTag}.
	 * @param ctx the parse tree
	 */
	void enterEndTag(XQueryParser.EndTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#endTag}.
	 * @param ctx the parse tree
	 */
	void exitEndTag(XQueryParser.EndTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterAp(XQueryParser.ApContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitAp(XQueryParser.ApContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StarRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterStarRp(XQueryParser.StarRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StarRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitStarRp(XQueryParser.StarRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterBinaryRp(XQueryParser.BinaryRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitBinaryRp(XQueryParser.BinaryRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagnameRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTagnameRp(XQueryParser.TagnameRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagnameRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTagnameRp(XQueryParser.TagnameRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TextRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTextRp(XQueryParser.TextRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TextRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTextRp(XQueryParser.TextRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterFilterRp(XQueryParser.FilterRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitFilterRp(XQueryParser.FilterRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAttrRp(XQueryParser.AttrRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAttrRp(XQueryParser.AttrRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BracketRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterBracketRp(XQueryParser.BracketRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BracketRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitBracketRp(XQueryParser.BracketRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParentRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterParentRp(XQueryParser.ParentRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParentRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitParentRp(XQueryParser.ParentRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CommaRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterCommaRp(XQueryParser.CommaRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CommaRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitCommaRp(XQueryParser.CommaRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelfRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSelfRp(XQueryParser.SelfRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelfRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSelfRp(XQueryParser.SelfRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryFta}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterUnaryFta(XQueryParser.UnaryFtaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryFta}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitUnaryFta(XQueryParser.UnaryFtaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryFt}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterBinaryFt(XQueryParser.BinaryFtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryFt}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitBinaryFt(XQueryParser.BinaryFtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegFt}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterNegFt(XQueryParser.NegFtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegFt}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitNegFt(XQueryParser.NegFtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StrEqFt}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterStrEqFt(XQueryParser.StrEqFtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StrEqFt}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitStrEqFt(XQueryParser.StrEqFtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundFt}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterCompoundFt(XQueryParser.CompoundFtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundFt}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitCompoundFt(XQueryParser.CompoundFtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BracketFt}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterBracketFt(XQueryParser.BracketFtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BracketFt}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitBracketFt(XQueryParser.BracketFtContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#pathOp}.
	 * @param ctx the parse tree
	 */
	void enterPathOp(XQueryParser.PathOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#pathOp}.
	 * @param ctx the parse tree
	 */
	void exitPathOp(XQueryParser.PathOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#docName}.
	 * @param ctx the parse tree
	 */
	void enterDocName(XQueryParser.DocNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#docName}.
	 * @param ctx the parse tree
	 */
	void exitDocName(XQueryParser.DocNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#fileName}.
	 * @param ctx the parse tree
	 */
	void enterFileName(XQueryParser.FileNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#fileName}.
	 * @param ctx the parse tree
	 */
	void exitFileName(XQueryParser.FileNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#attName}.
	 * @param ctx the parse tree
	 */
	void enterAttName(XQueryParser.AttNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#attName}.
	 * @param ctx the parse tree
	 */
	void exitAttName(XQueryParser.AttNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void enterBoolOp(XQueryParser.BoolOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void exitBoolOp(XQueryParser.BoolOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#filterOp}.
	 * @param ctx the parse tree
	 */
	void enterFilterOp(XQueryParser.FilterOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#filterOp}.
	 * @param ctx the parse tree
	 */
	void exitFilterOp(XQueryParser.FilterOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#stringCondition}.
	 * @param ctx the parse tree
	 */
	void enterStringCondition(XQueryParser.StringConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#stringCondition}.
	 * @param ctx the parse tree
	 */
	void exitStringCondition(XQueryParser.StringConditionContext ctx);
}