// Generated from ./XPath.g4 by ANTLR 4.13.1

package edu.ucsd.cse232b.autogen;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPathParser}.
 */
public interface XPathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterAp(XPathParser.ApContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitAp(XPathParser.ApContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StarRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterStarRp(XPathParser.StarRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StarRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitStarRp(XPathParser.StarRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterBinaryRp(XPathParser.BinaryRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitBinaryRp(XPathParser.BinaryRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagnameRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTagnameRp(XPathParser.TagnameRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagnameRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTagnameRp(XPathParser.TagnameRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TextRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTextRp(XPathParser.TextRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TextRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTextRp(XPathParser.TextRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterFilterRp(XPathParser.FilterRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitFilterRp(XPathParser.FilterRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAttrRp(XPathParser.AttrRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAttrRp(XPathParser.AttrRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BracketRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterBracketRp(XPathParser.BracketRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BracketRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitBracketRp(XPathParser.BracketRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParentRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterParentRp(XPathParser.ParentRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParentRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitParentRp(XPathParser.ParentRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CommaRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterCommaRp(XPathParser.CommaRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CommaRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitCommaRp(XPathParser.CommaRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelfRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSelfRp(XPathParser.SelfRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelfRp}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSelfRp(XPathParser.SelfRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryFta}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterUnaryFta(XPathParser.UnaryFtaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryFta}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitUnaryFta(XPathParser.UnaryFtaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterBinaryFt(XPathParser.BinaryFtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitBinaryFt(XPathParser.BinaryFtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterNegFt(XPathParser.NegFtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitNegFt(XPathParser.NegFtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StrEqFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterStrEqFt(XPathParser.StrEqFtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StrEqFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitStrEqFt(XPathParser.StrEqFtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterCompoundFt(XPathParser.CompoundFtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitCompoundFt(XPathParser.CompoundFtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BracketFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterBracketFt(XPathParser.BracketFtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BracketFt}
	 * labeled alternative in {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitBracketFt(XPathParser.BracketFtContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#pathOp}.
	 * @param ctx the parse tree
	 */
	void enterPathOp(XPathParser.PathOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#pathOp}.
	 * @param ctx the parse tree
	 */
	void exitPathOp(XPathParser.PathOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#docName}.
	 * @param ctx the parse tree
	 */
	void enterDocName(XPathParser.DocNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#docName}.
	 * @param ctx the parse tree
	 */
	void exitDocName(XPathParser.DocNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#fileName}.
	 * @param ctx the parse tree
	 */
	void enterFileName(XPathParser.FileNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#fileName}.
	 * @param ctx the parse tree
	 */
	void exitFileName(XPathParser.FileNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XPathParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XPathParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#attName}.
	 * @param ctx the parse tree
	 */
	void enterAttName(XPathParser.AttNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#attName}.
	 * @param ctx the parse tree
	 */
	void exitAttName(XPathParser.AttNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void enterBoolOp(XPathParser.BoolOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void exitBoolOp(XPathParser.BoolOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#filterOp}.
	 * @param ctx the parse tree
	 */
	void enterFilterOp(XPathParser.FilterOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#filterOp}.
	 * @param ctx the parse tree
	 */
	void exitFilterOp(XPathParser.FilterOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#stringCondition}.
	 * @param ctx the parse tree
	 */
	void enterStringCondition(XPathParser.StringConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#stringCondition}.
	 * @param ctx the parse tree
	 */
	void exitStringCondition(XPathParser.StringConditionContext ctx);
}