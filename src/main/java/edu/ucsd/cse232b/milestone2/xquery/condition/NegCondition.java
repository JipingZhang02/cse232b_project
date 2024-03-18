package edu.ucsd.cse232b.milestone2.xquery.condition;

import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import org.w3c.dom.Node;

import java.util.Map;

public class NegCondition implements Condition{
    private Condition conditionToNegate;

    public NegCondition(Condition conditionToNegate) {
        this.conditionToNegate = conditionToNegate;
    }

    @Override
    public boolean assess(Map<String, Node> variables) throws Exception {
        return !conditionToNegate.assess(variables);
    }

    @Override
    public Condition substitute(XQuery originXQuery, XQuery newXQuery) {
        conditionToNegate = conditionToNegate.substitute(originXQuery, newXQuery);
        return this;
    }

    @Override
    public String toString(){
        return "(not "+conditionToNegate.toString()+")";
    }
}
