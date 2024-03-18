package edu.ucsd.cse232b.milestone2.xquery.xq.decoratorQuery;

import edu.ucsd.cse232b.common.Util;
import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import edu.ucsd.cse232b.milestone2.xquery.xq.XQueryBuilderTool;
import edu.ucsd.cse232b.milestone2.xquery.condition.Condition;
import edu.ucsd.cse232b.milestone2.xquery.condition.True;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Map;

public class ForClause implements XQuery {
    private final List<String> forVarNames;
    private final List<XQuery> forXqs;
    private final List<String> letVarNames;
    private final List<XQuery> letXqs;
    private Condition whereCondition;
    private XQuery returnClauseXq;

    public ForClause(List<String> forVarNames, List<XQuery> forXqs, List<String> letVarNames, List<XQuery> letXqs, Condition whereCondition, XQuery returnClauseXq) {
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
        return XQueryBuilderTool.buildForClause(forVarNames,forXqs,letVarNames,letXqs,whereCondition,returnClauseXq,false).evaluate(input, variables);
    }

    @Override
    public XQuery substitute(XQuery originXQuery, XQuery newXQuery) {
        for (int i = 0; i < forXqs.size(); i++) {
            forXqs.set(i,forXqs.get(i).substitute(originXQuery, newXQuery));
        }
        for (int i = 0; i < letXqs.size(); i++) {
            letXqs.set(i,letXqs.get(i).substitute(originXQuery, newXQuery));
        }
        whereCondition = whereCondition.substitute(originXQuery, newXQuery);
        returnClauseXq = returnClauseXq.substitute(originXQuery, newXQuery);
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
        if (!(whereCondition instanceof True)){
            res.append("where ").append(whereCondition.toString()).append("\n");
        }
        res.append("return ").append(returnClauseXq.toString());
        return res.toString();
    }
}
