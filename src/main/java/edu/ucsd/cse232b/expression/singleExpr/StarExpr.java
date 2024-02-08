package edu.ucsd.cse232b.expression.singleExpr;

import edu.ucsd.cse232b.expression.Expression;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

// *
public class StarExpr implements Expression {
    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> res = new ArrayList<>();
        for (Node node:inputNodes){
            if (node.getNodeType()==Node.ELEMENT_NODE){
                res.add(node);
            }
        }
        return res;
    }
}
