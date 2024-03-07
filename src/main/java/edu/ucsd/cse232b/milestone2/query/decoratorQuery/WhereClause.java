package edu.ucsd.cse232b.milestone2.query.decoratorQuery;

import edu.ucsd.cse232b.common.Util;
import edu.ucsd.cse232b.milestone1.expression.EvalResult;
import edu.ucsd.cse232b.milestone2.query.Query;
import edu.ucsd.cse232b.milestone2.query.condition.Condition;
import edu.ucsd.cse232b.common.SlashStatus;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Map;

public class WhereClause implements Query {
    private Condition condition;
    private Query thenDoWhat;

    public WhereClause(Condition condition, Query thenDoWhat) {
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
    public Query substitute(Query originQuery, Query newQuery) {
        condition = condition.substitute(originQuery, newQuery);
        thenDoWhat = thenDoWhat.substitute(originQuery, newQuery);
        return this;
    }

    @Override
    public String toString(){
        return String.format("where (%s) \n%s\n",condition.toString(), Util.insertTabBeforeEachLine(thenDoWhat.toString()));
    }

/*    @Override
    public String serialize() {
        throw new RuntimeException("Object of this class cannot be serialized");
    }*/
}
