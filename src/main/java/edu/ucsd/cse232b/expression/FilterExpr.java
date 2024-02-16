package edu.ucsd.cse232b.expression;

import org.w3c.dom.Node;

import java.util.List;
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
}
