package edu.ucsd.cse232b.expression.binaryExpr;

import edu.ucsd.cse232b.expression.Expression;
import org.w3c.dom.Node;

import java.util.List;

public class ComaExpr extends BinaryExpr{

    public ComaExpr(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> res = left.evaluate(inputNodes);
        res.addAll(right.evaluate(inputNodes));
        return res;
    }

    @Override
    public Expression removeLeftmostSelfExpr() {
        this.left = this.left.removeLeftmostSelfExpr();
        this.right = this.right.removeLeftmostSelfExpr();
        return this;
    }
}
