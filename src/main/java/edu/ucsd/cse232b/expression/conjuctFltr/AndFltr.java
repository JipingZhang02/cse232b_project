package edu.ucsd.cse232b.expression.conjuctFltr;

import edu.ucsd.cse232b.expression.Expression;
import org.w3c.dom.Node;
import java.util.List;
import java.util.Objects;

public class AndFltr extends ConjuctFltr {
    public AndFltr(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> leftResult = leftExpression.evaluate(inputNodes);
        List<Node> rightResult = rightExpression.evaluate(inputNodes);
        leftResult.retainAll(rightResult);
        return leftResult;
    }
}
