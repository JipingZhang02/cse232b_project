package edu.ucsd.cse232b.query.condition;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.query.Query;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.*;

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
        Set<MyNode> leftNodesAsSet = new HashSet<>();
        for (Node w3cNode: leftRes.nodes){
            leftNodesAsSet.add(toMyNode(w3cNode));
        }
        for (Node w3cNode: rightRes.nodes){
            MyNode myNodeR = toMyNode(w3cNode);
            if (leftNodesAsSet.contains(myNodeR)){
                return true;
            }
        }
        return false;

/*        if (leftType==Node.TEXT_NODE){
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
        return false;*/
    }

    private static MyNode toMyNode(Node w3cNode){
        int type = w3cNode.getNodeType();
        if (type==Node.TEXT_NODE){
            return new MyStringNode(w3cNode.getNodeValue());
        }
        if (type!=Node.ELEMENT_NODE){
            return null;
        }
        MyElementNode res = new MyElementNode();
        NodeList childNodes = ((Element)w3cNode).getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            MyNode parsed = toMyNode(childNodes.item(i));
            if (parsed!=null){
                res.children.add(parsed);
            }
        }
        return res;
    }

    @Override
    public String toString(){
        return xqLeft.toString()+"="+xqRight.toString();
    }

    static class MyNode{

    }

    static class MyStringNode extends MyNode{
        String strValue="";

        MyStringNode(){

        }

        MyStringNode(String strValue) {
            this.strValue = strValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyStringNode that = (MyStringNode) o;
            return Objects.equals(strValue, that.strValue);
        }

        @Override
        public int hashCode() {
            return Objects.hash(strValue);
        }
    }

    static class MyElementNode extends MyNode{
        String tagName = "";
        List<MyNode> children = new ArrayList<>();

        public MyElementNode() {
        }

        public MyElementNode(String tagName) {
            this.tagName = tagName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyElementNode that = (MyElementNode) o;
            return Objects.equals(tagName, that.tagName) && Objects.equals(children, that.children);
        }

        @Override
        public int hashCode() {
            return Objects.hash(tagName, children);
        }
    }
}
