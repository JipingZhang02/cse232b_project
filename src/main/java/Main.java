import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File("j_caesar.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        Element rootElement = doc.getDocumentElement();
        Map<String,Element> xmlFiles = new HashMap<>();
        xmlFiles.put("j_caesar.xml",rootElement);


        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("./test_xpath.txt"));

        // Create a lexer
        XPathLexer lexer = new XPathLexer(input);

        // Token stream
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create a parser
        XPathParser parser = new XPathParser(tokens);

        // Parse the expression
        ParseTree tree = parser.abspath();

        // Visit the tree with our custom visitor
        EvalVisitor visitor = new EvalVisitor(xmlFiles);
        visitor.visit(tree);

        // Print the result
        System.out.println("Result: " + visitor.getRes());
    }

    public static class EvalVisitor extends XPathBaseVisitor<Void>{
        private final Map<String,Element> xmlFiles;
        private List<Element> res = new ArrayList<>();

        public EvalVisitor(Map<String, Element> xmlFiles) {
            if (xmlFiles==null){
                throw new RuntimeException("expecting a not null filename to xml file content map");
            }
            this.xmlFiles = xmlFiles;
        }

        public static List<Element> findAllChildrenElements(Element element, String tagName){
            List<Element> res = new ArrayList<>();
            Stack<Element> dfsStack = new Stack<>();
            dfsStack.add(element);
            while (!dfsStack.isEmpty()){
                Element toSearch = dfsStack.pop();
                if (toSearch.getTagName().equals(tagName)){
                    res.add(toSearch);
                } else {
                    NodeList childrenNodes = toSearch.getChildNodes();
                    int childCnt = childrenNodes.getLength();
                    for (int i = childCnt-1; i >=0 ; i--) {
                        Node node = childrenNodes.item(i);
                        if (!(node instanceof Element)){
                            continue;
                        }
                        dfsStack.add((Element) node);
                    }
                }
            }
            return res;
        }

        public static List<Element> findDirectChildrenElements(Element element, String tagName){
            List<Element> res = new ArrayList<>();
            NodeList childrenNodes = element.getChildNodes();
            int childCnt = childrenNodes.getLength();
            for (int i = 0; i < childCnt; i++) {
                Node node = childrenNodes.item(i);
                if (!(node instanceof Element)){
                    continue;
                }
                res.add((Element) node);
            }
            return res;
        }

        public List<Element> getRes() {
            return res;
        }

        @Override
        public Void visitAbsPath2(XPathParser.AbsPath2Context ctx) {
            String fileName = ctx.FileNameString().getText();
            if (!xmlFiles.containsKey(fileName)){
                throw new RuntimeException(String.format("could not file xml file %s",fileName));
            }
            Element rootElement = xmlFiles.get(fileName);
            res = findAllChildrenElements(r)
            return null;
        }

        @Override
        public Void visitAbsPath1(XPathParser.AbsPath1Context ctx) {
            return super.visitAbsPath1(ctx);
        }

        @Override
        public Void visitAllChildren(XPathParser.AllChildrenContext ctx) {
            return super.visitAllChildren(ctx);
        }

        @Override
        public Void visitAttrName(XPathParser.AttrNameContext ctx) {
            return super.visitAttrName(ctx);
        }

        @Override
        public Void visitRelPath2(XPathParser.RelPath2Context ctx) {
            return super.visitRelPath2(ctx);
        }

        @Override
        public Void visitBracketRelPath(XPathParser.BracketRelPathContext ctx) {
            return super.visitBracketRelPath(ctx);
        }

        @Override
        public Void visitTagName(XPathParser.TagNameContext ctx) {
            return super.visitTagName(ctx);
        }

        @Override
        public Void visitParent(XPathParser.ParentContext ctx) {
            return super.visitParent(ctx);
        }

        @Override
        public Void visitRelPath1(XPathParser.RelPath1Context ctx) {
            return super.visitRelPath1(ctx);
        }

        @Override
        public Void visitFilteredRelpath(XPathParser.FilteredRelpathContext ctx) {
            return super.visitFilteredRelpath(ctx);
        }

        @Override
        public Void visitRelPathTuple(XPathParser.RelPathTupleContext ctx) {
            return super.visitRelPathTuple(ctx);
        }

        @Override
        public Void visitCurrTag(XPathParser.CurrTagContext ctx) {
            return super.visitCurrTag(ctx);
        }

        @Override
        public Void visitGetText(XPathParser.GetTextContext ctx) {
            return super.visitGetText(ctx);
        }

        @Override
        public Void visitFilter(XPathParser.FilterContext ctx) {
            return super.visitFilter(ctx);
        }
    }
}