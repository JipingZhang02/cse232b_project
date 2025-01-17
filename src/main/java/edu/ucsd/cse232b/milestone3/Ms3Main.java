package edu.ucsd.cse232b.milestone3;

import edu.ucsd.cse232b.autogen.XQueryLexer;
import edu.ucsd.cse232b.autogen.XQueryParser;
import edu.ucsd.cse232b.common.Util;
import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import edu.ucsd.cse232b.milestone1.Ms1Main;
import edu.ucsd.cse232b.milestone2.Ms2Main;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.w3c.dom.Node;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class Ms3Main {
    public static void main(String[] args) throws Exception {
        Ms1Main.evaluateXPath("doc(\"j_caesar.xml\")//ACT"); // don't delete this line! we need to init Util.doc by this line
        String inputFilePath = "./xquery.txt";
        String optimizedQueryOutputPath="./xquery_optimized.txt";
        String outputFilePath = "./output.xml";
        if (args.length>=1){
            inputFilePath = args[0];
        }
        if (args.length>=2){
            outputFilePath = args[1];
        }
        if (args.length>=3){
            optimizedQueryOutputPath = args[2];
        }
        String queryStr = Ms2Main.readQuery(inputFilePath);
        XQuery XQuery = buildQuery(queryStr);
        saveQuery(XQuery,optimizedQueryOutputPath);
        List<Node> res = XQuery.evaluate(null,new HashMap<>()).nodes;
        Util.writeNodesToFile(res,outputFilePath);
    }

    public static void saveQuery(XQuery XQuery, String filePath) throws IOException{
        File file = new File(filePath);
        Writer writer = new FileWriter(file);
        String queryStr = XQuery.serialize();
        queryStr = Util.removeBlankLines(queryStr);
        writer.write(queryStr);
        writer.flush();
        writer.close();
        System.out.println("Optimized query has been successfully written to "+filePath);
    }


    public static XQuery buildQuery(String xQueryString){
        XQueryLexer lexer = new XQueryLexer(CharStreams.fromString(xQueryString));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        XQueryParser.XqContext xqContext = parser.xq();
        return Ms3XQueryBuilder.INSTANCE.visit(xqContext).left;
    }
}
