package edu.ucsd.cse232b.expression;

import org.w3c.dom.Node;

import java.util.List;

public class FilterExpr implements Expression{
    private final Expression expr,ft;

    public FilterExpr(Expression expr, Expression ft) {
        this.expr = expr;
        this.ft = ft;
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        return ft.evaluate(expr.evaluate(inputNodes));
    }
}
