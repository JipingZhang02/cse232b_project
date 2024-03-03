package edu.ucsd.cse232b.query.complexQuery;

import edu.ucsd.cse232b.common.Util;
import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import edu.ucsd.cse232b.common.SlashStatus;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SingleForClause implements Query {
    private final String varName;
    private Query generator;
    private Query returnClause;

    public SingleForClause(String varName, Query generator, Query returnClause) {
        this.varName = varName;
        this.generator = generator;
        this.returnClause = returnClause;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) throws Exception {
        List<Node> resNodes = new ArrayList<>();
        List<Node> varValues = generator.evaluate(input,variables).nodes;
        for (Node varValue:varValues){
            variables.put(varName,varValue);
            resNodes.addAll(returnClause.evaluate(input,variables).nodes);
        }
        return new EvalResult(resNodes, SlashStatus.NONE);
    }

    @Override
    public Query substitute(Query originQuery, Query newQuery) {
        generator = generator.substitute(originQuery, newQuery);
        returnClause = returnClause.substitute(originQuery, newQuery);
        return this;
    }

    @Override
    public String toString(){
        return String.format("for($%s in %s){\n%s\n}",varName,generator.toString(), Util.insertTabBeforeLines(returnClause.toString()));
    }

    @Override
    public String serialize() {
        throw new RuntimeException("Object of this class cannot be serialized");
    }
}
