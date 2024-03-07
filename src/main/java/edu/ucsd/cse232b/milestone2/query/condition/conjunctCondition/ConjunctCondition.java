package edu.ucsd.cse232b.milestone2.query.condition.conjunctCondition;

import edu.ucsd.cse232b.milestone2.query.Query;
import edu.ucsd.cse232b.milestone2.query.condition.Condition;

public abstract class ConjunctCondition implements Condition {
    protected Condition leftCondition,rightCondition;

    public ConjunctCondition(Condition leftCondition, Condition rightCondition) {
        this.leftCondition = leftCondition;
        this.rightCondition = rightCondition;
    }

    public Condition getLeftCondition() {
        return leftCondition;
    }

    public Condition getRightCondition() {
        return rightCondition;
    }

    @Override
    public Condition substitute(Query originQuery, Query newQuery) {
        leftCondition = leftCondition.substitute(originQuery, newQuery);
        rightCondition = rightCondition.substitute(originQuery, newQuery);
        return this;
    }
}
