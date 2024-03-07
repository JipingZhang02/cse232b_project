package edu.ucsd.cse232b.milestone1.expression.binaryExpr;

import edu.ucsd.cse232b.milestone1.expression.Expression;
import edu.ucsd.cse232b.milestone1.expression.singleExpr.SelfExpr;

public abstract class BinaryExpr implements Expression {
    protected Expression left,right;

    public BinaryExpr(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Expression removeLeftmostSelfExpr() {
        if (this.left instanceof SelfExpr){
            return this.right;
        } else {
            this.left = this.left.removeLeftmostSelfExpr();
            return this;
        }
    }
}
