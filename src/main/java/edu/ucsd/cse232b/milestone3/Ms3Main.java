package edu.ucsd.cse232b.milestone3;

import edu.ucsd.cse232b.autogen.XQueryLexer;
import edu.ucsd.cse232b.autogen.XQueryParser;
import edu.ucsd.cse232b.common.Util;
import edu.ucsd.cse232b.query.Query;
import edu.ucsd.cse232b.xpath.XPath;
import edu.ucsd.cse232b.xquery.QueryBuilder;
import edu.ucsd.cse232b.xquery.XQuery;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.w3c.dom.Node;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class Ms3Main {
    public static void main(String[] args) throws Exception {
        XPath.evaluateXPath("doc(\"j_caesar.xml\")//ACT"); // don't delete this line! we need to init Util.doc by this line
        String inputFilePath = "./xquery.txt";
        String outputFilePath = "./output.xml";
        if (args.length>=1){
            inputFilePath = args[0];
        }
        if (args.length>=2){
            outputFilePath = args[1];
        }
        String queryStr = XQuery.readQuery(inputFilePath);
        Query query = biuldQuery(queryStr);
        List<Node> res = query.evaluate(null,new HashMap<>()).nodes;
        Util.writeNodesToFile(res,outputFilePath);
    }


    public static Query biuldQuery(String xQueryString){
        XQueryLexer lexer = new XQueryLexer(CharStreams.fromString(xQueryString));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        XQueryParser.XqContext xqContext = parser.xq();
        return Ms3QueryBuilder.INSTANCE.visit(xqContext).left;
    }
}
