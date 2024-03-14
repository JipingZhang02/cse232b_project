package edu.ucsd.cse232b.milestone2.query.condition;

import edu.ucsd.cse232b.milestone1.expression.EvalResult;
import edu.ucsd.cse232b.milestone2.query.Query;
import edu.ucsd.cse232b.milestone2.query.singleQuery.ConstStringXq;
import edu.ucsd.cse232b.common.myNode.MyNode;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.*;

public class EqCondition implements Condition{
    public static final int EQ_SIGN = 1,DOUBLE_EQ_SIGN = 2,EQ_STR = 3,IS_STR = 4;
    private Query xqLeft,xqRight;
    private final int eqOpType;

    public EqCondition(Query xqLeft, Query xqRight,int eqOpType) {
        if (xqLeft instanceof ConstStringXq){ // make sure constant string is on right side
            Query temp = xqRight;
            xqRight = xqLeft;
            xqLeft = temp;
        }
        this.xqLeft = xqLeft;
        this.xqRight = xqRight;
        this.eqOpType = eqOpType;
    }

    public int getEqOpType() {
        return eqOpType;
    }

    public Query getXqLeft() {
        return xqLeft;
    }

    public Query getXqRight() {
        return xqRight;
    }

    @Override
    public boolean assess(Map<String, Node> variables) throws Exception{
        EvalResult leftRes = xqLeft.evaluate(new EvalResult(),variables);
        EvalResult rightRes = xqRight.evaluate(new EvalResult(),variables);
        return areEqual(leftRes,rightRes);
    }

    @Override
    public Condition substitute(Query originQuery, Query newQuery) {
        xqLeft = xqLeft.substitute(originQuery,newQuery);
        xqRight = xqRight.substitute(originQuery, newQuery);
        return this;
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
        Set<MyNode> leftNodesAsSet = new HashSet<>();
        for (Node w3cNode: leftRes.nodes){
            leftNodesAsSet.add(MyNode.toMyNode(w3cNode));
        }
        for (Node w3cNode: rightRes.nodes){
            MyNode myNodeR = MyNode.toMyNode(w3cNode);
            if (leftNodesAsSet.contains(myNodeR)){
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString(){
        return xqLeft.toString()+new String[]{"","=","=="," eq "," is "}[eqOpType]+xqRight.toString();
    }
}
