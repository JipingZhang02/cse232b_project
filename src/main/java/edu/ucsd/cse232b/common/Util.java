package edu.ucsd.cse232b.common;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.*;

public class Util {

    private static Document doc; // the fxxking w3c xml Node needs to have a Doc to be created

    private Util(){
        // this class shouldn't be instanced
    }

    public static void setDoc(Document doc) {
        Util.doc = doc;
    }

    public static List<Node> toJavaBuiltinList(NodeList nodeList){
        int l = nodeList.getLength();
        List<Node> res = new ArrayList<>(l);
        for (int i = 0; i < l; i++) {
            res.add(nodeList.item(i));
        }
        return res;
    }

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
        return removeRedaduntElements(res);
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
        List<T> res = new ArrayList<>();
        Set<T> existingElements = new HashSet<>();
        for (T element:input){
            if (existingElements.contains(element)){
                continue;
            }
            res.add(element);
            existingElements.add(element);
        }
        return res;
    }

    public static void writeNodesToFile(List<Node> nodes, String filename) {
        try {
            // Create a new Document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Create the <result> element
            Element searchResult = doc.createElement("result");
            doc.appendChild(searchResult);

            // Import and append each node to the <result> element
            for (Node node : nodes) {
                // Check if the node is an attribute node
                if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
                    // Create a <FakeNode> element
                    Element fakeNode = doc.createElement("FakeNode");
                    // Import the attribute node to the new document
                    Attr importedAttr = (Attr) doc.importNode(node, true);
                    // Add the attribute to <FakeNode>
                    fakeNode.setAttributeNode(importedAttr);
                    // Append <FakeNode> to <SearchResult>
                    searchResult.appendChild(fakeNode);
                } else {
                    // For non-attribute nodes, process normally
                    Node importedNode = doc.importNode(node, true);
                    searchResult.appendChild(importedNode);
                }
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
    public static Node assembleNode(String outerNodeName, List<Node> innerNodes){
        return assembleNode(outerNodeName,innerNodes,doc);
    }

    public static Node assembleNode(String outerNodeName, List<Node> innerNodes, Document doc) {
        try {
            // Create the outer element with the given name
            Element outerElement = doc.createElement(outerNodeName);

            for (Node innerNode:innerNodes) {
                // Determine the type of the innerNode and handle accordingly
                switch (innerNode.getNodeType()) {
                    case Node.ELEMENT_NODE:
                        // If innerNode is an element, import and append it to the outer element
                        Node importedElement = doc.importNode(innerNode, true);
                        outerElement.appendChild(importedElement);
                        break;
                    case Node.TEXT_NODE:
                        // If innerNode is pure text, append it directly to the outer element
                        Text importedText = doc.createTextNode(innerNode.getNodeValue());
                        outerElement.appendChild(importedText);
                        break;
                    case Node.ATTRIBUTE_NODE:
                        // If innerNode is an attribute, create a new element and set the attribute
                        Attr importedAttr = (Attr) doc.importNode(innerNode, true);
                        outerElement.setAttributeNode(importedAttr);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }

            return outerElement;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Text createTextNode( String textContent,Document doc) {
        if (doc == null) {
            throw new IllegalArgumentException("Document object cannot be null.");
        }
        if (textContent == null) {
            throw new IllegalArgumentException("Text content cannot be null.");
        }

        // Create and return the text node
        return doc.createTextNode(textContent);
    }

    public static Text createTextNode(String textContent){
        return createTextNode(textContent,doc);
    }

    /*
        This function is used for debug:
            It makes toString() method outputs a string with tabs, which look like java or cpp
     */
    public static String insertTabInLines(String string){
        StringBuilder res = new StringBuilder();
        String[] lines = string.split("\n");
        for (String line:lines){
            res.append("    ").append(line).append("\n");
        }
        return res.toString();
    }

    public static String removeDollarAndAtSign(String string){
        if (string==null){
            return null;
        }
        if (string.isEmpty()){
            return "";
        }
        if (string.startsWith("$")||string.startsWith("@")){
            return string.substring(1);
        }
        return string;
    }

    public static List<String> removeDollarAndAtSign(List<String> strings){
        List<String> res = new ArrayList<>();
        for (String string:strings){
            res.add(removeDollarAndAtSign(string));
        }
        return res;
    }
}
