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
import java.io.File;
import java.io.IOException;
import java.util.*;

public class XPath {
    public static final String[] xmlFilePaths = {"./j_caesar.xml","./test.xml"};


    public static void main(String[] args) throws Exception {
        Map<String,Node> xmlFiles = null;
        try{
            xmlFiles = loadXMLFiles();
        }
        catch (Exception e){
            e.printStackTrace();
            return;
        }
//        List<Node> res = evaluateXPath("doc(\"test.xml\")//CASE/BOOK",xmlFiles);
       // List<Node> res = evaluateXPath("doc(\"j_caesar.xml\")//SCENE[SPEECH/SPEAKER/text()=\"CAESAR\"]",xmlFiles);
       List<Node> res = evaluateXPath("doc(\"j_caesar.xml\")//ACT[SCENE[SPEECH/SPEAKER/text()=\"CAESAR\" and SPEECH/SPEAKER/text()=\"BRUTUS\"]]",xmlFiles);
//        List<Node> res = evaluateXPath("doc(\"test.xml\")//BOOK[TITLE/text()=\"literature\"]",xmlFiles);
//        List<Node> res = evaluateXPath("doc(\"test.xml\")//BOOK/TITLE/text()",xmlFiles);


       // List<Node> res = evaluateXPath("doc(\"test.xml\")//BOOKSHELF[BOOK]",xmlFiles);
        Util.writeNodesToFile(res,"./output.xml");
    }

    public static Map<String,Node> loadXMLFiles() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Map<String,Node> res = new HashMap<>();
        for (String path:xmlFilePaths){
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
