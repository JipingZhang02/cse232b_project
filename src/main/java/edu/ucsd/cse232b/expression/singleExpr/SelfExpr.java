package edu.ucsd.cse232b.expression.singleExpr;

import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.util.Util;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class SelfExpr implements Expression {
    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> res = new ArrayList<>();
        for(Node node:inputNodes){
            Node parent = node.getParentNode();
            if (!(parent instanceof Document)){
                res.add(parent);
            }
        }
        return Util.removeRedaduntElements(res);
    }
}
