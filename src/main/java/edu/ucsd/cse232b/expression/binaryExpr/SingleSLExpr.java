package edu.ucsd.cse232b.expression.binaryExpr;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.common.Consts;

//  rp1/rp2
public class SingleSLExpr extends BinaryExpr{
    public SingleSLExpr(Expression left, Expression right) {
        super(left, right);
    }

/*    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> leftRes = left.evaluate(inputNodes);
        return Util.removeRedaduntElements(right.evaluate(Util.findDirectChildrenNodes(leftRes)));
    }*/

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        EvalResult leftRes = left.evaluate(input);
        leftRes.slashStatus = Consts.SINGLE_SLASH;
        EvalResult res = right.evaluate(leftRes);
        return res;
    }
}
