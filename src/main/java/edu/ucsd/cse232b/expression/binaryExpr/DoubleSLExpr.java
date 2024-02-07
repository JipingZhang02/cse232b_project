package edu.ucsd.cse232b.expression.binaryExpr;

import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.util.Util;
import org.w3c.dom.Node;

import java.util.List;

public class DoubleSLExpr extends BinaryExpr{
    public DoubleSLExpr(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> leftRes = left.evaluate(inputNodes);
        leftRes = Util.findAllChildrenNodes(leftRes);
        return Util.removeRedaduntElements(right.evaluate(leftRes));
    }
}
