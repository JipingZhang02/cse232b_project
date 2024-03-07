package edu.ucsd.cse232b.milestone2.query.binaryQuery;

import edu.ucsd.cse232b.milestone1.expression.EvalResult;
import edu.ucsd.cse232b.milestone2.query.Query;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommaQuery implements Query {
    private Query leftQuery,rightQuery;

    public CommaQuery(Query leftQuery, Query rightQuery) {
        this.leftQuery = leftQuery;
        this.rightQuery = rightQuery;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) throws Exception {
        EvalResult leftResult = leftQuery.evaluate(input,variables);
        EvalResult rightResult = rightQuery.evaluate(input,variables);
        if (leftResult.slashStatus!=rightResult.slashStatus){
            throw new RuntimeException();
        }
        List<Node> resNodes = new ArrayList<>();
        resNodes.addAll(leftResult.nodes);
        resNodes.addAll(rightResult.nodes);
        return new EvalResult(resNodes, leftResult.slashStatus);
    }

    @Override
    public Query substitute(Query originQuery, Query newQuery) {
        leftQuery = leftQuery.substitute(originQuery, newQuery);
        rightQuery = rightQuery.substitute(originQuery, newQuery);
        return this;
    }


    @Override
    public String toString(){
        return leftQuery.toString()+","+rightQuery.toString();
    }
}
