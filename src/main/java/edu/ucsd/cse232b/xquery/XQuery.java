package edu.ucsd.cse232b.xquery;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import edu.ucsd.cse232b.autogen.XQueryLexer;
import edu.ucsd.cse232b.autogen.XQueryParser;
import edu.ucsd.cse232b.common.NodeComparator;
import edu.ucsd.cse232b.common.Util;
import edu.ucsd.cse232b.query.Query;
import edu.ucsd.cse232b.xpath.XPath;
import net.sf.saxon.Configuration;
import net.sf.saxon.dom.NodeOverNodeInfo;
import net.sf.saxon.om.TreeModel;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import java.net.URI;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.*;

import net.sf.saxon.s9api.*;
import org.w3c.dom.NodeList;

import javax.xml.transform.stream.StreamSource;

import static edu.ucsd.cse232b.common.Util.compareNodeLists;

public class XQuery {
    public static void main(String[] args) throws Exception {
        XPath.evaluateXPath("doc(\"j_caesar.xml\")//ACT",null); // don't delete this line! we need to init Util.doc by this line
        String inputFilePath = "./xquery.txt";
        String outputFilePath = "./output.xml";
        String outputBuildinFilePath = "./outputBuildin.xml";
        String inputXmlFileName = "j_caesar.xml";
        if (args.length>=1){
            inputFilePath = args[0];
        }
        if (args.length>=2){
            outputFilePath = args[1];
        }


//        // self implemented
        String queryStr = readQuery(inputFilePath);
        System.out.println(queryStr);
        Query query = biuldQuery(queryStr);
        List<Node> res = query.evaluate(null,new HashMap<>()).nodes;
        Util.writeNodesToFile(res,outputFilePath);

        //   built in
        List<Node> buildinRes = executeBuiltinXQuery(queryStr, inputXmlFileName);
        Util.writeNodesToFile(buildinRes,outputBuildinFilePath);

        // compare
        NodeComparator comparator = new NodeComparator();

        Collections.sort(res, comparator);
        Collections.sort(buildinRes, comparator);

        boolean areEqual = compareNodeLists(res, buildinRes);
        System.out.println("The two node lists are " + (areEqual ? "" : "not ") + "equal.");


    }

    public static List<Node> executeBuiltinXQuery(String xquery, String xmlFileName) {
        File xmlFile = new File(xmlFileName);
        String absolutePath = xmlFile.getAbsolutePath();
        String uri = new File(absolutePath).toURI().toString();
        List<Node> nodeList = new ArrayList<>();

        try {
            Processor processor = new Processor(false);

            XQueryCompiler compiler = processor.newXQueryCompiler();
            compiler.setBaseURI(new URI(uri));

            XQueryExecutable executable = compiler.compile(xquery);
            XQueryEvaluator evaluator = executable.load();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            DOMDestination destination = new DOMDestination(document);
            evaluator.run(destination);

            nodeList.add(document.getDocumentElement());

        } catch (SaxonApiException | javax.xml.parsers.ParserConfigurationException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return nodeList;
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

//public class XQuery {
//    public static void main(String[] args) {
//        File xmlFile = new File("j_caesar.xml");
//        String xquery = "for $x in //book return $x/title";
//
//        try {
//            Processor processor = new Processor(false);
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document document = builder.newDocument();
//
//            XQueryCompiler compiler = processor.newXQueryCompiler();
//            XQueryExecutable executable = compiler.compile(xquery);
//            XQueryEvaluator evaluator = executable.load();
//            XdmNode contextItem = processor.newDocumentBuilder().build(new StreamSource(xmlFile));
//            evaluator.setContextItem(contextItem);
//
//            XdmValue result = evaluator.evaluate();
//
//            List<Node> nodeList = new ArrayList<>();
//            Configuration config = processor.getUnderlyingConfiguration();
//
//            for (XdmItem item : result) {
//                if (item instanceof XdmNode) {
//                    Node domNode = document.importNode(
//                            NodeOverNodeInfo.wrap(((XdmNode) item).getUnderlyingNode()), true);
//                    nodeList.add(domNode);
//                }
//            }
//
//            // 使用 nodeList
//            nodeList.forEach(node -> System.out.println(node.getNodeName() + ": " + node.getTextContent()));
//
//        } catch (SaxonApiException | javax.xml.parsers.ParserConfigurationException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
