// Generated from XQuery.g4 by ANTLR 4.13.1

package edu.ucsd.cse232b.autogen;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForClause(XQueryParser.ForClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetClause(XQueryParser.LetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(XQueryParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnClause(XQueryParser.ReturnClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#variables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariables(XQueryParser.VariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#variableList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableList(XQueryParser.VariableListContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#joinClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinClause(XQueryParser.JoinClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagXq2}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagXq2(XQueryParser.TagXq2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code wsXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWsXq(XQueryParser.WsXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarXq(XQueryParser.VarXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LetXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetXq(XQueryParser.LetXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForXq(XQueryParser.ForXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code joinXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinXq(XQueryParser.JoinXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CommaXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommaXq(XQueryParser.CommaXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpXq(XQueryParser.RpXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringXq(XQueryParser.StringXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CommaXq2}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommaXq2(XQueryParser.CommaXq2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code ParaXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParaXq(XQueryParser.ParaXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ApXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApXq(XQueryParser.ApXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagXq(XQueryParser.TagXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConjunctCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunctCond(XQueryParser.ConjunctCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqCondDoubleMathOp}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqCondDoubleMathOp(XQueryParser.EqCondDoubleMathOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SatCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSatCond(XQueryParser.SatCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyCond(XQueryParser.EmptyCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegCond(XQueryParser.NegCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqCondEqStr}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqCondEqStr(XQueryParser.EqCondEqStrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParaCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParaCond(XQueryParser.ParaCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqCondMathOp}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqCondMathOp(XQueryParser.EqCondMathOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqCondIsStr}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqCondIsStr(XQueryParser.EqCondIsStrContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#satisfy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSatisfy(XQueryParser.SatisfyContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#startTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartTag(XQueryParser.StartTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#endTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndTag(XQueryParser.EndTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAp(XQueryParser.ApContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StarRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStarRp(XQueryParser.StarRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryRp(XQueryParser.BinaryRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagnameRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagnameRp(XQueryParser.TagnameRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TextRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextRp(XQueryParser.TextRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterRp(XQueryParser.FilterRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrRp(XQueryParser.AttrRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BracketRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketRp(XQueryParser.BracketRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParentRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentRp(XQueryParser.ParentRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CommaRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommaRp(XQueryParser.CommaRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelfRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfRp(XQueryParser.SelfRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryFta}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryFta(XQueryParser.UnaryFtaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryFt}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryFt(XQueryParser.BinaryFtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegFt}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegFt(XQueryParser.NegFtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StrEqFt}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrEqFt(XQueryParser.StrEqFtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundFt}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundFt(XQueryParser.CompoundFtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BracketFt}
	 * labeled alternative in {@link XQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketFt(XQueryParser.BracketFtContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#pathOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathOp(XQueryParser.PathOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#docName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocName(XQueryParser.DocNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#fileName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileName(XQueryParser.FileNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#attName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttName(XQueryParser.AttNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#boolOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOp(XQueryParser.BoolOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#filterOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterOp(XQueryParser.FilterOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#stringCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringCondition(XQueryParser.StringConditionContext ctx);
}