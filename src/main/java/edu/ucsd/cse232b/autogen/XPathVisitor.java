// Generated from ./XPath.g4 by ANTLR 4.13.1

package edu.ucsd.cse232b.autogen;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XPathParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XPathVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAp(XPathParser.ApContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StarRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStarRp(XPathParser.StarRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryRp(XPathParser.BinaryRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagnameRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagnameRp(XPathParser.TagnameRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TextRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextRp(XPathParser.TextRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterRp(XPathParser.FilterRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrRp(XPathParser.AttrRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BracketRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketRp(XPathParser.BracketRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParentRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentRp(XPathParser.ParentRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CommaRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommaRp(XPathParser.CommaRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelfRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfRp(XPathParser.SelfRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryFta}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryFta(XPathParser.UnaryFtaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryFt(XPathParser.BinaryFtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegFt(XPathParser.NegFtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StrEqFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrEqFt(XPathParser.StrEqFtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundFt(XPathParser.CompoundFtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BracketFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketFt(XPathParser.BracketFtContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#pathOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathOp(XPathParser.PathOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#docName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocName(XPathParser.DocNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#fileName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileName(XPathParser.FileNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(XPathParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#attName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttName(XPathParser.AttNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#boolOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOp(XPathParser.BoolOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#filterOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterOp(XPathParser.FilterOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#stringCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringCondition(XPathParser.StringConditionContext ctx);
}