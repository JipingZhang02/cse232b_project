package edu.ucsd.cse232b.milestone1.expression;

import java.util.Objects;

public class FilterExpr implements Expression{
    private final Expression expr,ft;

    public FilterExpr(Expression expr, Expression ft) {
        this.expr = expr;
        Objects.requireNonNull(ft, "filter is NULL!");
        this.ft = ft.removeLeftmostSelfExpr();
    }

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        return ft.evaluate(expr.evaluate(input));
    }

    @Override
    public String toString(){
        return expr.toString()+"["+ft.toString()+"]";
    }
}
