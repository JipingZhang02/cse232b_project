package edu.ucsd.cse232b.query.condition.conjunctCondition;

import edu.ucsd.cse232b.query.condition.Condition;
import org.w3c.dom.Node;

import java.util.Map;

public class AndCondition extends ConjunctCondition {
    public AndCondition(Condition leftCondition, Condition rightCondition) {
        super(leftCondition, rightCondition);
    }

    @Override
    public boolean assess(Map<String, Node> variables) throws Exception {
        return leftCondition.assess(variables) && rightCondition.assess(variables);
    }

    @Override
    public String toString(){
        return "("+leftCondition.toString()+" and "+rightCondition.toString()+")";
    }
}
