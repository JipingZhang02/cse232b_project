package edu.ucsd.cse232b.query.singleQuery;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import edu.ucsd.cse232b.util.Consts;
import edu.ucsd.cse232b.util.Util;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TagGeneratorQuery implements Query {
    private final String tagName;
    private final Query innerQuery;

    public TagGeneratorQuery(String tagName, Query innerQuery) {
        this.tagName = tagName;
        this.innerQuery = innerQuery;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) throws Exception {
        EvalResult innerResult = innerQuery.evaluate(input, variables);
        List<Node> generated = new ArrayList<>();
        for (Node node:innerResult.nodes){
            generated.add(Util.assembleNode(tagName,node));
        }
        return new EvalResult(generated, Consts.NONE);
    }
}
