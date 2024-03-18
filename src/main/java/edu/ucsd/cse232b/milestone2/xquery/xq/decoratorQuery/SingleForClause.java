package edu.ucsd.cse232b.milestone2.xquery.xq.decoratorQuery;

import edu.ucsd.cse232b.common.Util;
import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone2.xquery.XQuery;
import edu.ucsd.cse232b.common.SlashStatus;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SingleForClause implements XQuery {
    private final String varName;
    private XQuery generator;
    private XQuery returnClause;

    public SingleForClause(String varName, XQuery generator, XQuery returnClause) {
        this.varName = varName;
        this.generator = generator;
        this.returnClause = returnClause;
    }

    @Override
    public EvalResult evaluate(EvalResult input, Map<String, Node> variables) throws Exception {
        List<Node> resNodes = new ArrayList<>();
        List<Node> varValues = generator.evaluate(input,variables).nodes;
        for (Node varValue:varValues){
            variables.put(varName,varValue);
            resNodes.addAll(returnClause.evaluate(input,variables).nodes);
        }
        return new EvalResult(resNodes, SlashStatus.NONE);
    }

    @Override
    public XQuery substitute(XQuery originXQuery, XQuery newXQuery) {
        generator = generator.substitute(originXQuery, newXQuery);
        returnClause = returnClause.substitute(originXQuery, newXQuery);
        return this;
    }

    @Override
    public String toString(){
        return String.format("for $%s in %s\n%s\n",varName,generator.toString(), Util.insertTabBeforeEachLine(returnClause.toString()));
    }
}
