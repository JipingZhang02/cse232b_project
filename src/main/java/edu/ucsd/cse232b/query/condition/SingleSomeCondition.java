package edu.ucsd.cse232b.query.condition;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import org.w3c.dom.Node;

import java.util.Map;

public class SingleSomeCondition implements Condition{
    private final String varName;
    private final Query generator;
    private final Condition innerCondition;

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
}
