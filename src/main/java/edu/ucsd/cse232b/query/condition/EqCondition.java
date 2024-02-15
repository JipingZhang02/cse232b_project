package edu.ucsd.cse232b.query.condition;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import org.w3c.dom.Node;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EqCondition implements Condition{
    private final Query xqLeft,xqRight;

    public EqCondition(Query xqLeft, Query xqRight) {
        this.xqLeft = xqLeft;
        this.xqRight = xqRight;
    }

    @Override
    public boolean assess(Map<String, Node> variables) throws Exception{
        EvalResult leftRes = xqLeft.evaluate(new EvalResult(),variables);
        EvalResult rightRes = xqRight.evaluate(new EvalResult(),variables);
        return areEqual(leftRes,rightRes);
    }

    private static int getNodesType(EvalResult evalResult){
        int res = evalResult.nodes.get(0).getNodeType();
        for (Node node:evalResult.nodes){
            if (node.getNodeType()!=res){
                throw new RuntimeException();
            }
        }
        return res;
    }

    private static boolean areEqual(EvalResult leftRes,EvalResult rightRes){
        if (leftRes==null){
            return rightRes==null;
        }
        if (rightRes==null){
            return false;
        }
        if (leftRes.nodes.isEmpty()){
            return rightRes.nodes.isEmpty();
        }
        if (rightRes.nodes.isEmpty()){
            return false;
        }
        int leftType = getNodesType(leftRes);
        int rightType = getNodesType(rightRes);
        if (leftType!=rightType){
            return false;
        }
        if (leftType==Node.TEXT_NODE){
            Set<String> leftSet = new HashSet<>();
            for (Node node: leftRes.nodes){
                leftSet.add(node.getNodeValue());
            }
            for (Node node: rightRes.nodes){
                if (leftSet.contains(node.getNodeValue())){
                    return true;
                }
            }
            return false;
        }
        Set<Node> leftNodesAsSet = new HashSet<>(leftRes.nodes);
        for (Node node: rightRes.nodes){
            if (leftNodesAsSet.contains(node)){
                return true;
            }
        }
        return false;
    }
}
