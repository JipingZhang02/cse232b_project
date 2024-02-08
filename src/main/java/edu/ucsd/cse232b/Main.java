package edu.ucsd.cse232b;

import edu.ucsd.cse232b.util.Util;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File("./test.xml");
        Document doc = builder.parse(file);
        Node rootNode = doc.getDocumentElement();
        rootNode.normalize();
//        NodeList nodeList = rootNode.getChildNodes();
//        for (int i = 0; i < nodeList.getLength(); i++) {
//            System.out.println(nodeList.item(i));
//        }
        List<Node> nodes = Util.findAllChildrenNodes(rootNode);
        for (Node node:nodes){
            System.out.println(node.getNodeName());
        }
    }
}