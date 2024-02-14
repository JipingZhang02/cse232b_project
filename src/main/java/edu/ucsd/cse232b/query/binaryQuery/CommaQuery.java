package edu.ucsd.cse232b.query.binaryQuery;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommaQuery implements Query {
    private final Query leftQuery,rightQuery;

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
}
