package edu.ucsd.cse232b.expression.singleExpr;

import edu.ucsd.cse232b.expression.Expression;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class GetTextExpr implements Expression {
    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> res = new ArrayList<>();
        for (Node node:inputNodes){
            NodeList childNodes = node.getChildNodes();
            int l = childNodes.getLength();
            for (int i = 0; i < l; i++) {
                Node child = childNodes.item(i);
                if (child.getNodeType()==Node.TEXT_NODE){
                    res.add(child);
                }
            }
        }
        return res;
    }
}
