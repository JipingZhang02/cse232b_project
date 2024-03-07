package edu.ucsd.cse232b.milestone2.query.condition;

import edu.ucsd.cse232b.milestone2.query.Query;
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
    public Condition substitute(Query originQuery, Query newQuery) {
        conditionToNegate = conditionToNegate.substitute(originQuery, newQuery);
        return this;
    }

    @Override
    public String toString(){
        return "(not "+conditionToNegate.toString()+")";
    }
}
