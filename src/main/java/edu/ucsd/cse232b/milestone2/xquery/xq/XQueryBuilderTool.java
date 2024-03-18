package edu.ucsd.cse232b.milestone2.xquery.xq;

import edu.ucsd.cse232b.common.Util;
import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import edu.ucsd.cse232b.milestone2.xquery.xq.decoratorQuery.ForClause;
import edu.ucsd.cse232b.milestone2.xquery.condition.Condition;
import edu.ucsd.cse232b.milestone2.xquery.xq.decoratorQuery.SingleForClause;
import edu.ucsd.cse232b.milestone2.xquery.xq.decoratorQuery.SingleLetClause;
import edu.ucsd.cse232b.milestone2.xquery.xq.decoratorQuery.WhereClause;
import edu.ucsd.cse232b.milestone2.xquery.condition.SingleSomeCondition;

import java.util.ArrayList;
import java.util.List;

public class XQueryBuilderTool {
    private XQueryBuilderTool() {

    }

    public static XQuery buildLetClause(List<String> varNames, List<XQuery> xqs, XQuery thenDoWhat) {
        varNames = Util.removeDollarAndAtSign(varNames);
        if (varNames.size() != xqs.size()) {
            throw new IllegalArgumentException();
        }
        if (!(varNames instanceof ArrayList)) {
            varNames = new ArrayList<>(varNames);
        }
        if (!(xqs instanceof ArrayList)) {
            xqs = new ArrayList<>(xqs);
        }
        XQuery res = thenDoWhat;
        for (int i = varNames.size() - 1; i >= 0; i--) {
            res = new SingleLetClause(varNames.get(i), xqs.get(i), thenDoWhat);
        }
        return res;
    }

    public static XQuery buildForClause(List<String> forVarNames, List<XQuery> forXqs, List<String> letVarNames, List<XQuery> letXqs, Condition whereCondition, XQuery returnClauseXq, boolean lazyInit) {
        if (lazyInit){
            return new ForClause(forVarNames,forXqs,letVarNames,letXqs,whereCondition,returnClauseXq);
        }
        forVarNames = Util.removeDollarAndAtSign(forVarNames);
        letVarNames = Util.removeDollarAndAtSign(letVarNames);
        if (forVarNames.size() != forXqs.size()) {
            throw new IllegalArgumentException();
        }
        XQuery res = returnClauseXq;
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

    public static Condition buildSomeSatisfyCondition(List<String> varNames, List<XQuery> xqs, Condition innerCondition){
        varNames = Util.removeDollarAndAtSign(varNames);
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
            res = new SingleSomeCondition(varNames.get(i), xqs.get(i), res);
        }
        return res;
    }
}
