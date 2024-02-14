package edu.ucsd.cse232b.query.otherQuery;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import edu.ucsd.cse232b.util.Consts;
import edu.ucsd.cse232b.util.Util;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SingleForClause implements Query {
    private final String varName;
    private final Query generator;
    private final Query returnClause;

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
        return new EvalResult(resNodes, Consts.NONE);
    }
}
