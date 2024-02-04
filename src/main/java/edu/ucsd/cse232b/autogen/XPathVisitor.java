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
	 * Visit a parse tree produced by the {@code UnaryRp3}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryRp3(XPathParser.UnaryRp3Context ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryRp1}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryRp1(XPathParser.BinaryRp1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryRp4}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryRp4(XPathParser.UnaryRp4Context ctx);
	/**
	 * Visit a parse tree produced by the {@code ParaRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParaRp(XPathParser.ParaRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryRp2}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryRp2(XPathParser.BinaryRp2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryRp1}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryRp1(XPathParser.UnaryRp1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryRp2}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryRp2(XPathParser.UnaryRp2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterRp(XPathParser.FilterRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryRp5}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryRp5(XPathParser.UnaryRp5Context ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryRp6}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryRp6(XPathParser.UnaryRp6Context ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryFt1}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryFt1(XPathParser.BinaryFt1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryFt2}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryFt2(XPathParser.BinaryFt2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code ParaFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParaFt(XPathParser.ParaFtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegFt(XPathParser.NegFtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundFt(XPathParser.CompoundFtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryFt(XPathParser.UnaryFtContext ctx);
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
	 * Visit a parse tree produced by {@link XPathParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(XPathParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#stringCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringCondition(XPathParser.StringConditionContext ctx);
}