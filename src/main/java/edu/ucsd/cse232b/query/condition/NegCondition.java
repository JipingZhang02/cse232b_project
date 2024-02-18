package edu.ucsd.cse232b.query.condition;

import org.w3c.dom.Node;

import java.util.Map;

public class NegCondition implements Condition{
    private final Condition conditionToNegate;

    public NegCondition(Condition conditionToNegate) {
        this.conditionToNegate = conditionToNegate;
    }

    @Override
    public boolean assess(Map<String, Node> variables) throws Exception {
        return !conditionToNegate.assess(variables);
    }

    @Override
    public String toString(){
        return "(not "+conditionToNegate.toString()+")";
    }
}
