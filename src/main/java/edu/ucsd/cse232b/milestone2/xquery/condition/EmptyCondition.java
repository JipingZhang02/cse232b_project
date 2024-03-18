package edu.ucsd.cse232b.milestone2.xquery.condition;

import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import org.w3c.dom.Node;

import java.util.Map;

public class EmptyCondition implements Condition{
    private XQuery innerXq;

    public EmptyCondition(XQuery innerXq) {
        this.innerXq = innerXq;
    }

    @Override
    public boolean assess(Map<String, Node> variables) throws Exception {
        return innerXq.evaluate(new EvalResult(),variables).nodes.isEmpty();
    }

    @Override
    public Condition substitute(XQuery originXQuery, XQuery newXQuery) {
        innerXq = innerXq.substitute(originXQuery, newXQuery);
        return this;
    }

    @Override
    public String toString(){
        return "empty("+innerXq.toString()+")";
    }
}
