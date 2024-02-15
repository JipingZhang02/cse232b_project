package edu.ucsd.cse232b.query.condition.conjunctCondition;

import edu.ucsd.cse232b.query.condition.Condition;

public abstract class ConjunctCondition implements Condition {
    protected final Condition leftCondition,rightCondition;

    public ConjunctCondition(Condition leftCondition, Condition rightCondition) {
        this.leftCondition = leftCondition;
        this.rightCondition = rightCondition;
    }
}
