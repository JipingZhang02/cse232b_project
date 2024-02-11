package edu.ucsd.cse232b.xpath;

import edu.ucsd.cse232b.autogen.XPathLexer;
import edu.ucsd.cse232b.autogen.XPathParser;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.expression.absPathExpr.AbsPath;
import edu.ucsd.cse232b.util.NodeComparator;
import edu.ucsd.cse232b.util.Util;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.*;

// compare whether the results are correct
import javax.xml.xpath.*;
import javax.xml.xpath.XPath;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import static edu.ucsd.cse232b.util.Util.compareNodeLists;
import static edu.ucsd.cse232b.util.Util.nodeListToList;


public class Milestone1demotest {

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
        System.out.println(Arrays.toString(args));


//        String xpath = "doc(\"j_caesar.xml\")//PERSONA";
//        String xpathBuildin = "//PERSONA";

//        String xpath = "doc(\"j_caesar.xml\")//SCENE[SPEECH/SPEAKER/text()=\"CAESAR\"]";
//        String xpathBuildin = "//SCENE[SPEECH/SPEAKER/text()=\"CAESAR\"]";

//        String xpath = "doc(\"j_caesar.xml\")//ACT[SCENE[SPEECH/SPEAKER/text()=\"CAESAR\"] [SPEECH/SPEAKER/text()=\"BRUTUS\"]]";
//        String xpathBuildin = "//ACT[SCENE[SPEECH/SPEAKER/text()=\"CAESAR\"] [SPEECH/SPEAKER/text()=\"BRUTUS\"]]";

//        String xpath = "doc(\"j_caesar.xml\")//ACT[SCENE[SPEECH/SPEAKER/text()=\"CAESAR\" and SPEECH/SPEAKER/text()=\"BRUTUS\"]]";
//        String xpathBuildin = "//ACT[SCENE[SPEECH/SPEAKER/text()=\"CAESAR\" and SPEECH/SPEAKER/text()=\"BRUTUS\"]]";

//        String xpath = "doc(\"j_caesar.xml\")//(ACT,PERSONAE)/TITLE";
//        String xpathBuildin = "//ACT/TITLE | //PERSONAE/TITLE";

        String xpath = "doc(\"j_caesar.xml\")//ACT[not .//SPEAKER/text()=\"CAESAR\"]";
        String xpathBuildin = "//ACT[not(.//SPEAKER/text()=\"CAESAR\")]";

//        String xpath = "doc(\"j_caesar.xml\")//ACT[./TITLE]/*/SPEECH/../TITLE";
//        String xpathBuildin = "//ACT[./TITLE]/*/SPEECH/../TITLE";



        List<String> xmlFilePaths = DEFAULT_XML_FILE_PATHS;
        String outputPath = "./output.xml";
        String buildinOutputPath = "./outputBuildin.xml";

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse("j_caesar.xml");

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpathObj = xpathFactory.newXPath();
        NodeList builtInResult = (NodeList) xpathObj.evaluate(xpathBuildin, doc, XPathConstants.NODESET);

        Map<String, Node> xmlFiles = null;
        try{
            xmlFiles = loadXMLFiles(xmlFilePaths);
        }
        catch (Exception e){
            e.printStackTrace();
            return;
        }

        List<Node> res = evaluateXPath(xpath,xmlFiles);
        List<Node> builtInResultList = nodeListToList(builtInResult);


        Util.writeNodesToFile(res,outputPath);
        Util.writeNodesToFile(builtInResultList, buildinOutputPath);

        NodeComparator comparator = new NodeComparator();

        Collections.sort(res, comparator);
        Collections.sort(builtInResultList, comparator);

        System.out.println(res);
        System.out.println(builtInResultList);

        boolean areEqual = compareNodeLists(res, builtInResultList);
        System.out.println("The two node lists are " + (areEqual ? "" : "not ") + "equal.");

    }

    public static Map<String,Node> loadXMLFiles(List<String> paths) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Map<String,Node> res = new HashMap<>();
        for (String path: paths){
            File xmlFile = new File(path);
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
