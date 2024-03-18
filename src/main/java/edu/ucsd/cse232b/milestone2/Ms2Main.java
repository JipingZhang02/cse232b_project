package edu.ucsd.cse232b.milestone2;

import edu.ucsd.cse232b.autogen.XQueryLexer;
import edu.ucsd.cse232b.autogen.XQueryParser;
import edu.ucsd.cse232b.common.Util;
import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import edu.ucsd.cse232b.milestone1.Ms1Main;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.w3c.dom.Node;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class Ms2Main {
    public static void main(String[] args) throws Exception {
        Ms1Main.evaluateXPath("doc(\"j_caesar.xml\")//ACT"); // don't delete this line! we need to init Util.doc by this line
        String inputFilePath = "./xquery.txt";
        String outputFilePath = "./output.xml";
        if (args.length>=1){
            inputFilePath = args[0];
        }
        if (args.length>=2){
            outputFilePath = args[1];
        }
        String queryStr = readQuery(inputFilePath);
        XQuery XQuery = biuldQuery(queryStr);
        List<Node> res = XQuery.evaluate(null,new HashMap<>()).nodes;
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

    public static XQuery biuldQuery(String xQueryString){
        XQueryLexer lexer = new XQueryLexer(CharStreams.fromString(xQueryString));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        XQueryParser.XqContext xqContext = parser.xq();
        return XQueryBuilder.INSTANCE.visit(xqContext).left;
    }
}
