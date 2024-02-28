package edu.ucsd.cse232b.common;

import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node n1, Node n2) {
        // 比较基本特性：类型、名称、文本内容
        int basicComparison = compareBasicFeatures(n1, n2);
        if (basicComparison != 0) {
            return basicComparison;
        }

        // 比较属性
        int attributeComparison = compareAttributes(n1, n2);
        if (attributeComparison != 0) {
            return attributeComparison;
        }

        // 比较子节点
        return compareChildNodes(n1, n2);
    }

    private int compareBasicFeatures(Node n1, Node n2) {
        // 比较节点类型
        if (n1.getNodeType() != n2.getNodeType()) {
            return Integer.compare(n1.getNodeType(), n2.getNodeType());
        }

        // 比较节点名称
        int nameComparison = n1.getNodeName().compareTo(n2.getNodeName());
        if (nameComparison != 0) {
            return nameComparison;
        }

        // 比较文本内容
        String textContent1 = n1.getTextContent() != null ? n1.getTextContent().trim() : "";
        String textContent2 = n2.getTextContent() != null ? n2.getTextContent().trim() : "";
        return textContent1.compareTo(textContent2);
    }

    private int compareAttributes(Node n1, Node n2) {
        if (n1.getNodeType() == Node.ELEMENT_NODE) {
            NamedNodeMap attrs1 = n1.getAttributes();
            NamedNodeMap attrs2 = n2.getAttributes();

            // 比较属性数量
            if (attrs1.getLength() != attrs2.getLength()) {
                return Integer.compare(attrs1.getLength(), attrs2.getLength());
            }

            // 比较每个属性的名称和值
            for (int i = 0; i < attrs1.getLength(); i++) {
                Node attr1 = attrs1.item(i);
                Node attr2 = attrs2.getNamedItem(attr1.getNodeName());
                if (attr2 == null) {
                    return 1; // 第一个节点有一个额外的属性
                }

                int attrValueComparison = attr1.getNodeValue().compareTo(attr2.getNodeValue());
                if (attrValueComparison != 0) {
                    return attrValueComparison;
                }
            }
        }
        return 0;
    }

    private int compareChildNodes(Node n1, Node n2) {
        NodeList children1 = n1.getChildNodes();
        NodeList children2 = n2.getChildNodes();

        List<Node> childList1 = filterElementNodes(children1);
        List<Node> childList2 = filterElementNodes(children2);

        // 比较子节点数量
        if (childList1.size() != childList2.size()) {
            return Integer.compare(childList1.size(), childList2.size());
        }

        // 递归比较每个子节点
        for (int i = 0; i < childList1.size(); i++) {
            int childComparison = compare(childList1.get(i), childList2.get(i));
            if (childComparison != 0) {
                return childComparison;
            }
        }

        return 0;
    }

    private List<Node> filterElementNodes(NodeList nodeList) {
        List<Node> elementNodes = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                elementNodes.add(nodeList.item(i));
            }
        }
        return elementNodes;
    }
}
