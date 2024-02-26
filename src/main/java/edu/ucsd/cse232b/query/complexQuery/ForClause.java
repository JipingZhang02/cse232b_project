package edu.ucsd.cse232b.query.complexQuery;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import edu.ucsd.cse232b.query.QueryBuilderTool;
import edu.ucsd.cse232b.query.condition.Condition;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ForClause implements Query {
    private final List<String> forVarNames;
    private final List<Query> forXqs;
    private final List<String> letVarNames;
    private final List<Query> letXqs;
    private final Condition whereCondition;
    private final Query returnClauseXq;

    public ForClause(List<String> forVarNames, List<Query> forXqs, List<String> letVarNames, List<Query> letXqs, Condition whereCondition, Query returnClauseXq) {
        this.forVarNames = forVarNames;
        this.forXqs = forXqs;
        this.letVarNames = letVarNames;
        this.letXqs = letXqs;
        this.whereCondition = whereCondition;
        this.returnClauseXq = returnClauseXq;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) throws Exception {
        return QueryBuilderTool.buildForClause(forVarNames,forXqs,letVarNames,letXqs,whereCondition,returnClauseXq).evaluate(input, variables);
    }
}
