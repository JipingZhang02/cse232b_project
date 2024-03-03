package edu.ucsd.cse232b.query.condition;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import org.w3c.dom.Node;

import java.util.Map;

public class EmptyCondition implements Condition{
    private Query innerXq;

    public EmptyCondition(Query innerXq) {
        this.innerXq = innerXq;
    }

    @Override
    public boolean assess(Map<String, Node> variables) throws Exception {
        return innerXq.evaluate(new EvalResult(),variables).nodes.isEmpty();
    }

    @Override
    public Condition substitute(Query originQuery, Query newQuery) {
        innerXq = innerXq.substitute(originQuery, newQuery);
        return this;
    }

    @Override
    public String toString(){
        return "empty("+innerXq.toString()+")";
    }
}
