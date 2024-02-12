package edu.ucsd.cse232b.expression.singleExpr;

import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.util.Util;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class ParentExpr implements Expression {
    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> res = new ArrayList<>();
        for(Node node:inputNodes){
            Node parent = node.getParentNode();
            if (!(parent instanceof Document)){
                Node pp = parent.getParentNode();
                if (!(pp instanceof Document)){
                    res.add(pp);
                }
            }
        }
        return Util.removeRedaduntElements(res);
    }
}
