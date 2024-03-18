package edu.ucsd.cse232b.milestone2.xquery.condition.conjunctCondition;

import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import edu.ucsd.cse232b.milestone2.xquery.condition.Condition;

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
    public Condition substitute(XQuery originXQuery, XQuery newXQuery) {
        leftCondition = leftCondition.substitute(originXQuery, newXQuery);
        rightCondition = rightCondition.substitute(originXQuery, newXQuery);
        return this;
    }
}
