package edu.ucsd.cse232b.milestone2.query;

import edu.ucsd.cse232b.milestone1.expression.EvalResult;
import edu.ucsd.cse232b.milestone1.expression.Expression;
import org.w3c.dom.Node;

import java.util.Map;

/*
    Using adapter mode here:
        ExpressionWrapper contains an expression while implements Query.
    This class will be used when a whole absolute path in XPath is interpreted as an XQuery
 */
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
    public Query substitute(Query originQuery, Query newQuery) {
        return this;
    }

    @Override
    public String toString(){
        return expression.toString();
    }
}
