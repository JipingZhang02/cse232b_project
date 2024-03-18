package edu.ucsd.cse232b.milestone2.xquery.xq.singleQuery;

import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.common.Util;
import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.Map;

public class TagGeneratorXQuery implements XQuery {
    private final String tagName;
    private XQuery innerXQuery;

    public TagGeneratorXQuery(String tagName, XQuery innerXQuery) {
        this.tagName = tagName;
        this.innerXQuery = innerXQuery;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) throws Exception {
        EvalResult innerResult = innerXQuery.evaluate(input, variables);
        return new EvalResult(Arrays.asList(Util.assembleNode(tagName,innerResult.nodes)), SlashStatus.NONE);
    }

    @Override
    public XQuery substitute(XQuery originXQuery, XQuery newXQuery) {
        innerXQuery = innerXQuery.substitute(originXQuery, newXQuery);
        return this;
    }

    @Override
    public String toString(){
        return String.format("<%s>{\n%s\n}</%s>",tagName,Util.insertTabBeforeEachLine(innerXQuery.toString()),tagName);
    }
}
