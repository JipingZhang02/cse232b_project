package edu.ucsd.cse232b.milestone2.xquery.xq.binaryQuery;

import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommaXQuery implements XQuery {
    private XQuery leftXQuery, rightXQuery;

    public CommaXQuery(XQuery leftXQuery, XQuery rightXQuery) {
        this.leftXQuery = leftXQuery;
        this.rightXQuery = rightXQuery;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) throws Exception {
        EvalResult leftResult = leftXQuery.evaluate(input,variables);
        EvalResult rightResult = rightXQuery.evaluate(input,variables);
        if (leftResult.slashStatus!=rightResult.slashStatus){
            throw new RuntimeException();
        }
        List<Node> resNodes = new ArrayList<>();
        resNodes.addAll(leftResult.nodes);
        resNodes.addAll(rightResult.nodes);
        return new EvalResult(resNodes, leftResult.slashStatus);
    }

    @Override
    public XQuery substitute(XQuery originXQuery, XQuery newXQuery) {
        leftXQuery = leftXQuery.substitute(originXQuery, newXQuery);
        rightXQuery = rightXQuery.substitute(originXQuery, newXQuery);
        return this;
    }


    @Override
    public String toString(){
        return leftXQuery.toString()+","+ rightXQuery.toString();
    }
}
