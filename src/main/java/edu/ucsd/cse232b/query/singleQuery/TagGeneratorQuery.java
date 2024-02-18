package edu.ucsd.cse232b.query.singleQuery;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.common.Util;
import org.w3c.dom.Node;

import java.util.Arrays;
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
        return new EvalResult(Arrays.asList(Util.assembleNode(tagName,innerResult.nodes)), SlashStatus.NONE);
    }

    @Override
    public String toString(){
        return String.format("<%s>{\n%s\n}</%s>",tagName,Util.insertTabInLines(innerQuery.toString()),tagName);
    }
}
