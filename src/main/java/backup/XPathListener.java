package backup;// Generated from XPath.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPathParser}.
 */
public interface XPathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code AbsPath2}
	 * labeled alternative in {@link XPathParser#abspath}.
	 * @param ctx the parse tree
	 */
	void enterAbsPath2(XPathParser.AbsPath2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code AbsPath2}
	 * labeled alternative in {@link XPathParser#abspath}.
	 * @param ctx the parse tree
	 */
	void exitAbsPath2(XPathParser.AbsPath2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code AbsPath1}
	 * labeled alternative in {@link XPathParser#abspath}.
	 * @param ctx the parse tree
	 */
	void enterAbsPath1(XPathParser.AbsPath1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code AbsPath1}
	 * labeled alternative in {@link XPathParser#abspath}.
	 * @param ctx the parse tree
	 */
	void exitAbsPath1(XPathParser.AbsPath1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code AllChildren}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void enterAllChildren(XPathParser.AllChildrenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AllChildren}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void exitAllChildren(XPathParser.AllChildrenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrName}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void enterAttrName(XPathParser.AttrNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrName}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void exitAttrName(XPathParser.AttrNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelPath2}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void enterRelPath2(XPathParser.RelPath2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code RelPath2}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void exitRelPath2(XPathParser.RelPath2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code BracketRelPath}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void enterBracketRelPath(XPathParser.BracketRelPathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BracketRelPath}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void exitBracketRelPath(XPathParser.BracketRelPathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagName}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XPathParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagName}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XPathParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void enterParent(XPathParser.ParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void exitParent(XPathParser.ParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelPath1}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void enterRelPath1(XPathParser.RelPath1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code RelPath1}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void exitRelPath1(XPathParser.RelPath1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code FilteredRelpath}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void enterFilteredRelpath(XPathParser.FilteredRelpathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilteredRelpath}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void exitFilteredRelpath(XPathParser.FilteredRelpathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelPathTuple}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void enterRelPathTuple(XPathParser.RelPathTupleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelPathTuple}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void exitRelPathTuple(XPathParser.RelPathTupleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CurrTag}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void enterCurrTag(XPathParser.CurrTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CurrTag}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void exitCurrTag(XPathParser.CurrTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GetText}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void enterGetText(XPathParser.GetTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GetText}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 */
	void exitGetText(XPathParser.GetTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFilter(XPathParser.FilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFilter(XPathParser.FilterContext ctx);
}