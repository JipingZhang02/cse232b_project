package edu.ucsd.cse232b.milestone2.xquery.condition;

import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import org.w3c.dom.Node;

import java.util.Map;

public class SingleSomeCondition implements Condition{
    private final String varName;
    private XQuery generator;
    private Condition innerCondition;

    public SingleSomeCondition(String varName, XQuery generator, Condition innerCondition) {
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
    public Condition substitute(XQuery originXQuery, XQuery newXQuery) {
        generator = generator.substitute(originXQuery, newXQuery);
        innerCondition = innerCondition.substitute(originXQuery, newXQuery);
        return this;
    }

    @Override
    public String toString(){
        return String.format("some($%s in %s) satisfies (%s)",varName,generator.toString(),innerCondition.toString());
    }
}
