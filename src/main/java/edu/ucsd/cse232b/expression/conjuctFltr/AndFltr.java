package edu.ucsd.cse232b.expression.conjuctFltr;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.util.Consts;
import org.w3c.dom.Node;

import java.util.*;

public class AndFltr extends ConjuctFltr {
    public AndFltr(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

/*    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> leftResult = leftExpression.evaluate(inputNodes);
        List<Node> rightResult = rightExpression.evaluate(inputNodes);
        leftResult.retainAll(rightResult);
        return leftResult;
    }*/

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        List<Node> leftRes = leftExpression.evaluate(input).nodes;
        List<Node> rightRes = rightExpression.evaluate(input).nodes;
        Set<Node> toSaveSet = new HashSet<>();
        toSaveSet.addAll(leftRes);
        toSaveSet.addAll(rightRes);
        List<Node> resList = new ArrayList<>();
        for (Node node:input.nodes){
            if (toSaveSet.contains(node)){
                resList.add(node);
            }
        }
        return new EvalResult(resList, Consts.NONE);
    }
}
