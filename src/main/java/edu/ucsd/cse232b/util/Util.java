package edu.ucsd.cse232b.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Util {

    public static List<Node> findAllChildrenNodes(Node node) {
        List<Node> allNodes = new ArrayList<>();
        dfs(node, allNodes);
        return allNodes;
    }

    private static void dfs(Node node, List<Node> allNodes) {
        if (node == null) {
            return;
        }

        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node child = nodeList.item(i);
            // Check if the node is a text node and if it is not just whitespace
            if (!(child.getNodeType() == Node.TEXT_NODE && child.getNodeValue().trim().isEmpty())) {
                allNodes.add(child); // Add the child node to the list
                dfs(child, allNodes); // Recurse on the child node to explore its children
            }
        }
    }

    public static List<Node> findAllChildrenNodes(List<Node> nodes) {
        List<Node> res = new ArrayList<>();
        for (Node node:nodes) res.addAll(findAllChildrenNodes(node));
        return res;
    }

    public static List<Node> findDirectChildrenNodes(List<Node> nodes) {
        List<Node> res = new ArrayList<>();
        for (Node node:nodes){
            NodeList nodeList = node.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                res.add(nodeList.item(i));
            }
        }
        return res;
    }

    public static <T> List<T> removeRedaduntElements(List<T> input) {
        return new ArrayList<>(new HashSet<>(input));
    }

    public static void writeNodesToFile(List<Node> nodes, String filename) {
        try {
            // Create a new Document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Create the <SearchResult> element
            Element searchResult = doc.createElement("SearchResult");
            doc.appendChild(searchResult);

            // Import and append each node to the <SearchResult> element
            for (Node node : nodes) {
                Node importedNode = doc.importNode(node, true);
                searchResult.appendChild(importedNode);
            }

            // Output the document to a file
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            transformer.transform(source, result);

            System.out.println("Nodes have been written to " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
