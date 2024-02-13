package edu.ucsd.cse232b.expression.binaryExpr;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.util.Consts;
import edu.ucsd.cse232b.util.Util;
import org.w3c.dom.Node;

import java.util.List;

public class DoubleSLExpr extends BinaryExpr{
    public DoubleSLExpr(Expression left, Expression right) {
        super(left, right);
    }

/*    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> leftRes = left.evaluate(inputNodes);
        return Util.removeRedaduntElements(right.evaluate(Util.findAllChildrenNodes(leftRes)));
    }*/

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        EvalResult leftRes = left.evaluate(input);
        leftRes.slashStatus = Consts.DOUBLE_SLASH;
        return right.evaluate(leftRes);
    }
}
