package edu.ucsd.cse232b.expression.conjuctFltr;

import edu.ucsd.cse232b.expression.Expression;
import org.w3c.dom.Node;
import java.util.List;
import java.util.Objects;

public abstract class ConjuctFltr implements Expression {
    protected final Expression leftExpression;
    protected final Expression rightExpression;

    public ConjuctFltr(Expression leftExpression, Expression rightExpression) {
        Objects.requireNonNull(leftExpression, "Left expression is null!");
        Objects.requireNonNull(rightExpression, "Right expression is null!");
/*        this.leftExpression = leftExpression.removeLeftmostSelfExpr();
        this.rightExpression = rightExpression.removeLeftmostSelfExpr();  */
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
}

