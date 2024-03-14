package edu.ucsd.cse232b.common.myNode;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
    The foolish w3c Node doesn't view two nodes in different positions with same content to be equal
    So, we should define a MyNode type, and override hash() and equals() methods according to our need
 */
public interface MyNode {
    Node toW3cNode();
    
    public static MyNode toMyNode(Node w3cNode){
        int type = w3cNode.getNodeType();
        if (type==Node.TEXT_NODE){
            return new MyStringNode(w3cNode.getNodeValue());
        }
        if (type!=Node.ELEMENT_NODE){
            return null;
        }
        MyElementNode res = new MyElementNode();
        res.tagName = w3cNode.getNodeName();
        NodeList childNodes = ((Element)w3cNode).getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            MyNode parsed = toMyNode(childNodes.item(i));
            if (parsed!=null){
                res.children.add(parsed);
            }
        }
        return res;
    }
}
