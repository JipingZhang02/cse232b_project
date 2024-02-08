package edu.ucsd.cse232b.expression.binaryExpr;

import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.util.Util;
import org.w3c.dom.Node;

import java.util.List;

//  rp1/rp2
public class SingleSLExpr extends BinaryExpr{
    public SingleSLExpr(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> leftRes = left.evaluate(inputNodes);
        return Util.removeRedaduntElements(right.evaluate(Util.findDirectChildrenNodes(leftRes)));
    }
}
