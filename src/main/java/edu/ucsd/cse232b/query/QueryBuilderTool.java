package edu.ucsd.cse232b.query;

import edu.ucsd.cse232b.query.condition.Condition;
import edu.ucsd.cse232b.query.complexQuery.SingleForClause;
import edu.ucsd.cse232b.query.complexQuery.SingleLetClause;
import edu.ucsd.cse232b.query.complexQuery.WhereClause;
import edu.ucsd.cse232b.query.condition.SingleSomeCondition;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilderTool {
    private QueryBuilderTool() {

    }

    public static Query buildLetClause(List<String> varNames, List<Query> xqs, Query thenDoWhat) {
        if (varNames.size() != xqs.size()) {
            throw new IllegalArgumentException();
        }
        if (!(varNames instanceof ArrayList)) {
            varNames = new ArrayList<>(varNames);
        }
        if (!(xqs instanceof ArrayList)) {
            xqs = new ArrayList<>(xqs);
        }
        Query res = thenDoWhat;
        for (int i = varNames.size() - 1; i >= 0; i--) {
            res = new SingleLetClause(varNames.get(i), xqs.get(i), thenDoWhat);
        }
        return res;
    }

    public static Query buildForClause(List<String> forVarNames, List<Query> forXqs, List<String> letVarNames, List<Query> letXqs, Condition whereCondition, Query returnClauseXq) {
        if (forVarNames.size() != forXqs.size()) {
            throw new IllegalArgumentException();
        }
        Query res = returnClauseXq;
        res = new WhereClause(whereCondition, res);
        res = buildLetClause(letVarNames, letXqs, res);
        if (!(forVarNames instanceof ArrayList)) {
            forVarNames = new ArrayList<>(forVarNames);
        }
        if (!(forXqs instanceof ArrayList)) {
            forXqs = new ArrayList<>(forXqs);
        }
        for (int i = forVarNames.size() - 1; i >= 0; i--) {
            res = new SingleForClause(forVarNames.get(i), forXqs.get(i), res);
        }
        return res;
    }

    public static Condition buildSomeSatisfyCondition(List<String> varNames, List<Query> xqs, Condition innerCondition){
        if (varNames.size() != xqs.size()) {
            throw new IllegalArgumentException();
        }
        if (!(varNames instanceof ArrayList)) {
            varNames = new ArrayList<>(varNames);
        }
        if (!(xqs instanceof ArrayList)) {
            xqs = new ArrayList<>(xqs);
        }
        Condition res = innerCondition;
        for (int i = varNames.size() - 1; i >= 0; i--) {
            res = new SingleSomeCondition(varNames.get(i), xqs.get(i), innerCondition);
        }
        return res;
    }
}
