package edu.ucsd.cse232b.query.otherQuery;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import edu.ucsd.cse232b.query.condition.Condition;
import edu.ucsd.cse232b.util.Consts;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Map;

public class SingleWhereClause implements Query {
    private final Condition condition;
    private final Query thenDoWhat;

    public SingleWhereClause(Condition condition, Query thenDoWhat) {
        this.condition = condition;
        this.thenDoWhat = thenDoWhat;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) throws Exception {
        if (condition.assess(variables)){
            return thenDoWhat.evaluate(input, variables);
        } else {
            return new EvalResult(new ArrayList<>(), Consts.NONE);
        }
    }
}
