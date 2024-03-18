package edu.ucsd.cse232b.milestone2.xquery.condition.conjunctCondition;

import edu.ucsd.cse232b.milestone2.xquery.condition.Condition;
import org.w3c.dom.Node;

import java.util.Map;

public class OrCondition extends ConjunctCondition {
    public OrCondition(Condition leftCondition, Condition rightCondition) {
        super(leftCondition, rightCondition);
    }

    @Override
    public boolean assess(Map<String, Node> variables) throws Exception {
        return leftCondition.assess(variables) || rightCondition.assess(variables);
    }

    @Override
    public String toString(){
        return "("+leftCondition.toString()+" or "+rightCondition.toString()+")";
    }
}
