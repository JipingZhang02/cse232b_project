package backup;// Generated from XPath.g4 by ANTLR 4.13.1
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
	 * Visit a parse tree produced by the {@code AbsPath2}
	 * labeled alternative in {@link XPathParser#abspath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsPath2(XPathParser.AbsPath2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code AbsPath1}
	 * labeled alternative in {@link XPathParser#abspath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsPath1(XPathParser.AbsPath1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code AllChildren}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllChildren(XPathParser.AllChildrenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrName}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrName(XPathParser.AttrNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelPath2}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelPath2(XPathParser.RelPath2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code BracketRelPath}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketRelPath(XPathParser.BracketRelPathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagName}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(XPathParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParent(XPathParser.ParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelPath1}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelPath1(XPathParser.RelPath1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code FilteredRelpath}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilteredRelpath(XPathParser.FilteredRelpathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelPathTuple}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelPathTuple(XPathParser.RelPathTupleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CurrTag}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurrTag(XPathParser.CurrTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GetText}
	 * labeled alternative in {@link XPathParser#relpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetText(XPathParser.GetTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter(XPathParser.FilterContext ctx);
}