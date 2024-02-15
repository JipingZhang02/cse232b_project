package edu.ucsd.cse232b.query.complexQuery;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Map;

public class SingleLetClause implements Query {
    private final String varName;
    private final Query assignedValXQ;
    private final Query thenDoWhat;

    public SingleLetClause(String varName, Query assignedValXQ, Query thenDoWhat) {
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
    }
}
