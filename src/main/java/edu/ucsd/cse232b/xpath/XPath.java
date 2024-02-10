package edu.ucsd.cse232b.xpath;

import edu.ucsd.cse232b.autogen.XPathLexer;
import edu.ucsd.cse232b.autogen.XPathParser;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.expression.absPathExpr.AbsPath;
import edu.ucsd.cse232b.util.Util;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.*;

public class XPath {
    public static final List<String> DEFAULT_XML_FILE_PATHS = Arrays.asList("./j_caesar.xml","./test.xml");


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
        List<String> xmlFilePaths = DEFAULT_XML_FILE_PATHS;
        String outputPath = "./output.xml";


/*        if (args.length==0){
            //System.out.println("Error usage!");
            //return;
        } else {
            xpath = args[args.length - 1];
            String[] argsWithoutXPath = new String[args.length - 1];
            System.arraycopy(args, 0, argsWithoutXPath, 0, args.length - 1);
            Map<String, List<String>> keywordArgs = parseArgs(argsWithoutXPath);
            if (keywordArgs.containsKey("-i")) {
                xmlFilePaths = keywordArgs.get("-i");
            }
            if (keywordArgs.containsKey("-o")) {
                List<String> outputPathAsList = keywordArgs.get("-o");
                if (outputPathAsList.size() != 1) {
                    System.out.println("Error usage, you have to specify 1 and only 1 output path after '-o'");
                }
                outputPath = outputPathAsList.get(0);
            }
        }*/

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
                outputPath = args[2];
                System.out.println("using customized output path: ");
            }
        } else {
            System.out.println("error! please specify the xpath input file");
            return;
        }

        System.out.println("start evaluating query:    "+xpath);


        Map<String,Node> xmlFiles = null;
        try{
            xmlFiles = loadXMLFiles(xmlFilePaths);
        }
        catch (Exception e){
            e.printStackTrace();
            return;
        }


//        List<Node> res = evaluateXPath("doc(\"test.xml\")//CASE/BOOK",xmlFiles);
       // List<Node> res = evaluateXPath("doc(\"j_caesar.xml\")//SCENE[SPEECH/SPEAKER/text()=\"CAESAR\"]",xmlFiles);
       //List<Node> res = evaluateXPath("doc(\"j_caesar.xml\")//ACT[SCENE[SPEECH/SPEAKER/text()=\"CAESAR\" and SPEECH/SPEAKER/text()=\"BRUTUS\"]]",xmlFiles);
//        List<Node> res = evaluateXPath("doc(\"test.xml\")//BOOK[TITLE/text()=\"literature\"]",xmlFiles);
//        List<Node> res = evaluateXPath("doc(\"test.xml\")//BOOK/TITLE/text()",xmlFiles);
       // List<Node> res = evaluateXPath("doc(\"test.xml\")//BOOKSHELF[BOOK]",xmlFiles);

        List<Node> res = evaluateXPath(xpath,xmlFiles);
        Util.writeNodesToFile(res,outputPath);
    }

    public static Map<String,Node> loadXMLFiles(List<String> paths) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Map<String,Node> res = new HashMap<>();
        for (String path: paths){
            File xmlFile = new File(path);
            if (!xmlFile.exists()){
                continue; // ignore unexisting files
            }
            res.put(xmlFile.getName(), builder.parse(xmlFile).getDocumentElement());
        }
        return res;
    }

    public static List<Node> evaluateXPath(String xPath, Map<String,Node> xmlFiles) throws Exception {
        XPathLexer lexer = new XPathLexer(CharStreams.fromString(xPath));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XPathParser parser = new XPathParser(tokens);
        XPathParser.ApContext apContext = parser.ap();
        ExpressionBuilder expressionBuilder = new ExpressionBuilder();
        Expression expression = expressionBuilder.visit(apContext);
        if (!(expression instanceof AbsPath)){
            throw new RuntimeException();
        }
        AbsPath xpathAsAbsPath = (AbsPath) expression;
        String filename = xpathAsAbsPath.getFileName();
        if (!xmlFiles.containsKey(filename)){
            return new ArrayList<>();
        }
        List<Node> initialNode = Arrays.asList(xmlFiles.get(filename));
        return expression.evaluate(initialNode);
    }
}
