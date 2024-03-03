package edu.ucsd.cse232b.query.complexQuery;

import edu.ucsd.cse232b.common.Util;
import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import edu.ucsd.cse232b.query.QueryBuilderTool;
import edu.ucsd.cse232b.query.condition.Condition;
import edu.ucsd.cse232b.query.condition.IdentityCondition;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ForClause implements Query {
    private final List<String> forVarNames;
    private final List<Query> forXqs;
    private final List<String> letVarNames;
    private final List<Query> letXqs;
    private Condition whereCondition;
    private Query returnClauseXq;

    public ForClause(List<String> forVarNames, List<Query> forXqs, List<String> letVarNames, List<Query> letXqs, Condition whereCondition, Query returnClauseXq) {
        forVarNames = Util.removeDollarAndAtSign(forVarNames);
        letVarNames = Util.removeDollarAndAtSign(letVarNames);
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

    @Override
    public Query substitute(Query originQuery, Query newQuery) {
        for (int i = 0; i < forXqs.size(); i++) {
            forXqs.set(i,forXqs.get(i).substitute(originQuery, newQuery));
        }
        for (int i = 0; i < letXqs.size(); i++) {
            letXqs.set(i,letXqs.get(i).substitute(originQuery, newQuery));
        }
        whereCondition = whereCondition.substitute(originQuery, newQuery);
        returnClauseXq = returnClauseXq.substitute(originQuery,newQuery);
        return this;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("for ");
        for (int i = 0; i < forVarNames.size(); i++) {
            if(i!=0){
                res.append("    ");
            }
            res.append("$").append(forVarNames.get(i)).append(" in ").append(forXqs.get(i).toString());
            if (i!=forVarNames.size()-1){
                res.append(",");
            }
            res.append("\n");
        }
        if (!letVarNames.isEmpty()) {
            res.append("let");
            for (int i = 0; i < letVarNames.size(); i++) {
                if (i != 0) {
                    res.append("    ");
                }
                res.append("$").append(letVarNames.get(i)).append(" = ").append(letXqs.get(i).toString());
                if (i!= letVarNames.size()-1){
                    res.append(",");
                }
                res.append("\n");
            }
        }
        if (!(whereCondition instanceof IdentityCondition)){
            res.append("where ").append(whereCondition.toString()).append("\n");
        }
        res.append("return ").append(returnClauseXq.toString());
        return res.toString();
    }
}
