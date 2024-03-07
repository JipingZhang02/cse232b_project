package edu.ucsd.cse232b.milestone1.expression.binaryFltr;

import edu.ucsd.cse232b.milestone1.expression.Expression;

import java.util.Objects;

public abstract class BinaryFltr implements Expression {

    protected final Expression leftRp;
    protected final Expression rightRp;

    public BinaryFltr(Expression leftRp, Expression rightRp) {
        Objects.requireNonNull(leftRp, "leftRp is NULL!");
        this.leftRp = leftRp.removeLeftmostSelfExpr();
        if (rightRp!=null) {
            this.rightRp = rightRp.removeLeftmostSelfExpr();
        } else {
            this.rightRp = null;
        }
    }

}

