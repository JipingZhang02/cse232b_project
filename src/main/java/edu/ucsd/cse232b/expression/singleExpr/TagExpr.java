package edu.ucsd.cse232b.expression.singleExpr;

import edu.ucsd.cse232b.expression.Expression;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class TagExpr implements Expression {
    private final String tagName;

    public TagExpr(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> res = new ArrayList<>();
        for (Node node:inputNodes){
            NodeList childNodes = node.getChildNodes();
            int l = childNodes.getLength();
            for (int i = 0; i < l; i++) {
                Node child = childNodes.item(i);
                if (child.getNodeType()==Node.ELEMENT_NODE&&child.getNodeName().equals(tagName)){
                    res.add(child);
                }
            }
        }
        return res;
    }
}
