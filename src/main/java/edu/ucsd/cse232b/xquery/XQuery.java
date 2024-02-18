package edu.ucsd.cse232b.xquery;

import edu.ucsd.cse232b.autogen.XQueryLexer;
import edu.ucsd.cse232b.autogen.XQueryParser;
import edu.ucsd.cse232b.common.Util;
import edu.ucsd.cse232b.query.Query;
import edu.ucsd.cse232b.xpath.XPath;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.w3c.dom.Node;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class XQuery {
    public static void main(String[] args) throws Exception {
        XPath.evaluateXPath("doc(\"j_caesar.xml\")//ACT",null);
        String inputFilePath = "./xquery.txt";
        String outputFilePath = "./output.xml";
        if (args.length>=1){
            inputFilePath = args[0];
        }
        if (args.length>=2){
            outputFilePath = args[1];
        }
        String queryStr = readQuery(inputFilePath);
        Query query = biuldQuery(queryStr);
        List<Node> res = query.evaluate(null,new HashMap<>()).nodes;
        Util.writeNodesToFile(res,outputFilePath);
    }

    public static String readQuery(String inputFilePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(inputFilePath))));
        StringBuilder res = new StringBuilder();
        while (true){
            String line = bufferedReader.readLine();
            if (line==null){
                return res.toString();
            }
            line = line.trim();
            line = line.replace("\n","").replace("\r","");
            if (line.length()==0){
                return res.toString();
            }
            res.append(line).append(" ");
        }
    }

    public static Query biuldQuery(String xQueryString){
        XQueryLexer lexer = new XQueryLexer(CharStreams.fromString(xQueryString));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        XQueryParser.XqContext xqContext = parser.xq();
        return QueryBuilder.INSTANCE.visit(xqContext).left;
    }
}
