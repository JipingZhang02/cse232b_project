package edu.ucsd.cse232b.expression.singleFltr;

import edu.ucsd.cse232b.expression.Expression;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Objects;

public class ParanthesisFltr implements Expression {

    private final Expression ft;

    public ParanthesisFltr(Expression ft) {
        Objects.requireNonNull(ft, "filter is NULL!");
        this.ft = ft.removeLeftmostSelfExpr();
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        return this.ft.evaluate(inputNodes);
    }

}
