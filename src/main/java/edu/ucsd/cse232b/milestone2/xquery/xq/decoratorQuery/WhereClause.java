package edu.ucsd.cse232b.milestone2.xquery.xq.decoratorQuery;

import edu.ucsd.cse232b.common.Util;
import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import edu.ucsd.cse232b.milestone2.xquery.condition.Condition;
import edu.ucsd.cse232b.common.SlashStatus;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Map;

public class WhereClause implements XQuery {
    private Condition condition;
    private XQuery thenDoWhat;

    public WhereClause(Condition condition, XQuery thenDoWhat) {
        this.condition = condition;
        this.thenDoWhat = thenDoWhat;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) throws Exception {
        if (condition.assess(variables)){
            return thenDoWhat.evaluate(input, variables);
        } else {
            return new EvalResult(new ArrayList<>(), SlashStatus.NONE);
        }
    }

    @Override
    public XQuery substitute(XQuery originXQuery, XQuery newXQuery) {
        condition = condition.substitute(originXQuery, newXQuery);
        thenDoWhat = thenDoWhat.substitute(originXQuery, newXQuery);
        return this;
    }

    @Override
    public String toString(){
        return String.format("where (%s) \n%s\n",condition.toString(), Util.insertTabBeforeEachLine(thenDoWhat.toString()));
    }
}
