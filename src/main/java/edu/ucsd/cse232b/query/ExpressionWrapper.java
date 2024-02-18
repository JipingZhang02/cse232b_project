package edu.ucsd.cse232b.query;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Map;

public class ExpressionWrapper implements Query{
    private final Expression expression;

    public ExpressionWrapper(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) throws Exception {
        return expression.evaluate(input);
    }

    @Override
    public String toString(){
        return expression.toString();
    }
}
