package edu.ucsd.cse232b.expression.singleExpr;

import edu.ucsd.cse232b.expression.Expression;
import org.w3c.dom.Node;

import java.util.List;

public class SelfExpr implements Expression {
    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        return inputNodes;
    }
}