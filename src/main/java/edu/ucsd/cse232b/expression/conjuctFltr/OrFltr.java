package edu.ucsd.cse232b.expression.conjuctFltr;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.common.SlashStatus;
import org.w3c.dom.Node;

import java.util.*;

public class OrFltr extends ConjuctFltr {
    public OrFltr(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        List<Node> leftRes = leftExpression.evaluate(input).nodes;
        List<Node> rightRes = rightExpression.evaluate(input).nodes;
        Set<Node> toSaveSet = new HashSet<>();
        Set<Node> rightResAsSet = new HashSet<>(rightRes);
        for (Node lNode:leftRes){
            if (rightResAsSet.contains(lNode)){
                toSaveSet.add(lNode);
            }
        }
        List<Node> resList = new ArrayList<>();
        for (Node node:input.nodes){
            if (toSaveSet.contains(node)){
                resList.add(node);
            }
        }
        return new EvalResult(resList, SlashStatus.NONE);
    }

    @Override
    public String toString(){
        return "("+leftExpression.toString()+" or "+rightExpression.toString()+")";
    }
}

