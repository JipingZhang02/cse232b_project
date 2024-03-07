package edu.ucsd.cse232b.milestone2.query.condition;

import edu.ucsd.cse232b.milestone1.expression.EvalResult;
import edu.ucsd.cse232b.milestone2.query.Query;
import org.w3c.dom.Node;

import java.util.Map;

public class SingleSomeCondition implements Condition{
    private final String varName;
    private Query generator;
    private Condition innerCondition;

    public SingleSomeCondition(String varName, Query generator, Condition innerCondition) {
        this.varName = varName;
        this.generator = generator;
        this.innerCondition = innerCondition;
    }

    @Override
    public boolean assess(Map<String, Node> variables) throws Exception {
        for (Node varValue:generator.evaluate(new EvalResult(),variables).nodes){
            variables.put(varName,varValue);
            if (innerCondition.assess(variables)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Condition substitute(Query originQuery, Query newQuery) {
        generator = generator.substitute(originQuery, newQuery);
        innerCondition = innerCondition.substitute(originQuery, newQuery);
        return this;
    }

    @Override
    public String toString(){
        return String.format("some($%s in %s) satisfies (%s)",varName,generator.toString(),innerCondition.toString());
    }

    @Override
    public String serialize() {
        throw new RuntimeException("Object of this class cannot be serialized");
    }
}
