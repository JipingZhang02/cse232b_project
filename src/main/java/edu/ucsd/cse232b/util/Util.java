package edu.ucsd.cse232b.util;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Util {
    public static List<Element> findAllChildrenElements(Element element, String tagName) {
        List<Element> res = new ArrayList<>();
        Stack<Element> dfsStack = new Stack<>();
        dfsStack.add(element);
        while (!dfsStack.isEmpty()) {
            Element toSearch = dfsStack.pop();
            if (toSearch.getTagName().equals(tagName)) {
                res.add(toSearch);
            } else {
                NodeList childrenNodes = toSearch.getChildNodes();
                int childCnt = childrenNodes.getLength();
                for (int i = childCnt - 1; i >= 0; i--) {
                    Node node = childrenNodes.item(i);
                    if (!(node instanceof Element)) {
                        continue;
                    }
                    dfsStack.add((Element) node);
                }
            }
        }
        return res;
    }

    public static List<Node> findAllChildrenNodes(Node node) {
        List<Node> res = new ArrayList<>();
        Stack<Node> dfsStack = new Stack<>();
        dfsStack.push(node);
        while (!dfsStack.isEmpty()) {
            Node nodeToSearch = dfsStack.pop();
            res.add(nodeToSearch);
            NodeList children = node.getChildNodes();
            int l = children.getLength();
            for (int i = l - 1; i >= 0; i--) {
                dfsStack.push(children.item(i));
            }
        }
        return res;
    }

    public static List<Node> findAllChildrenNodes(List<Node> nodes) {
        List<Node> res = new ArrayList<>();
        for (Node node:nodes) res.addAll(findAllChildrenNodes(node));
        return res;
    }

    public static <T> List<T> removeRedaduntElements(List<T> input) {
        return new ArrayList<>(new HashSet<>(input));
    }
}
