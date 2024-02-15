package edu.ucsd.cse232b.query.condition;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import org.w3c.dom.Node;

import java.util.Map;

public class EmptyCondition implements Condition{
    private final Query innerXq;

    public EmptyCondition(Query innerXq) {
        this.innerXq = innerXq;
    }

    @Override
    public boolean assess(Map<String, Node> variables) throws Exception {
        return innerXq.evaluate(new EvalResult(),variables).nodes.isEmpty();
    }
}
