package edu.ucsd.cse232b.milestone2.query.decoratorQuery;

import edu.ucsd.cse232b.milestone1.expression.EvalResult;
import edu.ucsd.cse232b.milestone2.query.Query;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Map;

public class SingleLetClause implements Query {
    private final String varName;
    private Query assignedValXQ;
    private Query thenDoWhat;

    public SingleLetClause(String varName, Query assignedValXQ, Query thenDoWhat) {
        if (varName.startsWith("$")) varName = varName.substring(1);
        this.varName = varName;
        this.assignedValXQ = assignedValXQ;
        this.thenDoWhat = thenDoWhat;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) throws Exception {
        List<Node> assignedVal = assignedValXQ.evaluate(input, variables).nodes;
        if (assignedVal.size()!=1){
            throw new RuntimeException("error, expecting 1 val to assign to $"+varName+", actually got "+assignedVal.size());
        }
        variables.put(varName,assignedVal.get(0));
        return thenDoWhat.evaluate(input,variables);
/*        List<Node> resNodes = new ArrayList<>();
        for (Node assignedVal1:assignedVal){
            variables.put(varName,assignedVal1);
            resNodes.addAll(thenDoWhat.evaluate(input,variables).nodes);
        }
        return new EvalResult(resNodes, SlashStatus.NONE);*/
    }

    @Override
    public Query substitute(Query originQuery, Query newQuery) {
        assignedValXQ = assignedValXQ.substitute(originQuery, newQuery);
        thenDoWhat = thenDoWhat.substitute(originQuery, newQuery);
        return this;
    }

    @Override
    public String toString(){
        return String.format("let $%s = %s\n%s",varName,assignedValXQ.toString(),thenDoWhat.toString());
    }
}
