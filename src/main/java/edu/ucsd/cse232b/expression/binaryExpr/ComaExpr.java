package edu.ucsd.cse232b.expression.binaryExpr;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class ComaExpr extends BinaryExpr {

    public ComaExpr(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        EvalResult leftResult = left.evaluate(input);
        EvalResult rightResult = right.evaluate(input);
        if (leftResult.slashStatus!=rightResult.slashStatus){
            throw new RuntimeException();
        }
        List<Node> resNodes = new ArrayList<>();
        resNodes.addAll(leftResult.nodes);
        resNodes.addAll(rightResult.nodes);
        return new EvalResult(resNodes, leftResult.slashStatus);
    }

    @Override
    public Expression removeLeftmostSelfExpr() {
        this.left = this.left.removeLeftmostSelfExpr();
        this.right = this.right.removeLeftmostSelfExpr();
        return this;
    }

    @Override
    public String toString(){
        return left.toString()+","+right.toString();
    }
}
