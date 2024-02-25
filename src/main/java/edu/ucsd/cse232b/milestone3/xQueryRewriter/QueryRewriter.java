package edu.ucsd.cse232b.milestone3.xQueryRewriter;

import edu.ucsd.cse232b.autogen.XQueryBaseVisitor;
import edu.ucsd.cse232b.autogen.XQueryLexer;
import edu.ucsd.cse232b.autogen.XQueryParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class QueryRewriter extends XQueryBaseVisitor<String> {
    public static String rewriteQuery(String xQueryString){
        XQueryLexer lexer = new XQueryLexer(CharStreams.fromString(xQueryString));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        XQueryParser.XqContext xqContext = parser.xq();
        return INSTANCE.visit(xqContext);
    }

    private static final QueryRewriter INSTANCE = new QueryRewriter();

    private QueryRewriter() {

    }

    @Override
    public String visit(ParseTree tree) {
        return tree.getText();
    }
}
