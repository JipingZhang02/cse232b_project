package edu.ucsd.cse232b.xpath;

import edu.ucsd.cse232b.autogen.XPathLexer;
import edu.ucsd.cse232b.autogen.XPathParser;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.common.Util;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class XPath {



    private static Map<String,List<String>> parseArgs(String[] args){
        Map<String,List<String>> res = new HashMap<>();
        String key = "default";
        List<String> currKeyRes = new ArrayList<>();
        for (String arg:args){
            if (arg.startsWith("-")){
                res.put(key,currKeyRes);
                key = arg;
                currKeyRes = new ArrayList<>();
            } else {
                currKeyRes.add(arg);
            }
        }
        res.put(key,currKeyRes);
        return res;
    }

    private static void printHelpInfo(){
        System.out.println("Usage: java -jar XPath [-i <path_to_xml.xml> <path_to_xml2.xml>] [-o <expected_output_path.xml>] <xpath>");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("program running with args: "+Arrays.toString(args));


        String xpath = "doc(\"j_caesar.xml\")//ACT[not .//SPEAKER/text()=\"CAESAR\"]";
        String outputPath = "./output.xml";


        if (args.length>=1){
            String pathToQueryFile = args[0];
            File queryFile = new File(pathToQueryFile);
            if (!queryFile.exists()){
                System.out.println("the specified query file "+queryFile.getAbsolutePath()+" doesn't exist!");
                return;
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(queryFile)));
            String query = reader.readLine();
            reader.close();
            xpath = query;
            if (args.length>=2){
                outputPath = args[1];
                System.out.println("using customized output path: ");
            }
        } else {
            System.out.println("error! please specify the xpath input file");
            return;
        }

        System.out.println("start evaluating query:    "+xpath);


        Map<String,Node> xmlFiles = null;
        List<Node> res = evaluateXPath(xpath,xmlFiles);
        Util.writeNodesToFile(res,outputPath);
    }



    public static Expression buildApExpression(String xPath){
        XPathLexer lexer = new XPathLexer(CharStreams.fromString(xPath));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XPathParser parser = new XPathParser(tokens);
        XPathParser.ApContext apContext = parser.ap();
        return ExpressionBuilder.INSTANCE.visit(apContext);
    }

    public static Expression buildRpExpression(String relPath){
        XPathLexer lexer = new XPathLexer(CharStreams.fromString(relPath));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XPathParser parser = new XPathParser(tokens);
        XPathParser.RpContext rpContext = parser.rp();
        return ExpressionBuilder.INSTANCE.visit(rpContext);
    }

    public static List<Node> evaluateXPath(String xPath, Map<String,Node> xmlFiles) throws Exception {
        Expression expression = buildApExpression(xPath);
        return expression.evaluate(null).nodes;
    }
}
