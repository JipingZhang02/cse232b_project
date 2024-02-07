package edu.ucsd.cse232b.expression.binaryExpr;

import edu.ucsd.cse232b.expression.Expression;

public abstract class BinaryExpr implements Expression {
    protected final Expression left,right;

    public BinaryExpr(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
