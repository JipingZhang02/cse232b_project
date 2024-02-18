package edu.ucsd.cse232b.expression.singleFltr;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.common.SlashStatus;
import org.w3c.dom.Node;

import java.util.*;

public class NegFltr implements Expression {

    private final Expression ft;

    public NegFltr(Expression ft) {
        Objects.requireNonNull(ft, "filter is NULL!");
        this.ft = ft.removeLeftmostSelfExpr();
    }

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        Set<Node> nodesToExclude = new HashSet<>(ft.evaluate(input).nodes);
        List<Node> resList = new ArrayList<>();
        for (Node node:input.nodes){
            if (nodesToExclude.contains(node)){
                continue;
            }
            resList.add(node);
        }
        return new EvalResult(resList, SlashStatus.NONE);
    }

    @Override
    public String toString(){
        return "(not"+ft.toString()+")";
    }
}
