package edu.ucsd.cse232b.expression.singleFltr;

import edu.ucsd.cse232b.expression.Expression;
import org.w3c.dom.Node;

import java.util.List;

public class ParanthesisFltr implements Expression {

    final private Expression ft;

    public ParanthesisFltr(Expression ft) {
        if (ft == null) {
            throw new NullPointerException("Filter is null!");
        }
        this.ft = ft;
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        return this.ft.evaluate(inputNodes);
    }

}
