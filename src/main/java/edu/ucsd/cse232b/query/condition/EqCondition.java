package edu.ucsd.cse232b.query.condition;

import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.singleExpr.GetTextExpr;
import edu.ucsd.cse232b.query.Query;
import edu.ucsd.cse232b.query.binaryQuery.XQSlashRP;
import edu.ucsd.cse232b.query.singleQuery.ConstStringXq;
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
        if (eqOpType==EQ_STR&&((!(xqLeft instanceof ConstStringXq)) && (xqRight instanceof ConstStringXq))){
            /*
                according to examples on project document,
                ($var eq "string") should be treated as ($var/text()="string")
             */
            xqLeft = new XQSlashRP(xqLeft,new GetTextExpr(), SlashStatus.SINGLE_SLASH);
        }
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
            leftNodesAsSet.add(toMyNode(w3cNode));
        }
        for (Node w3cNode: rightRes.nodes){
            MyNode myNodeR = toMyNode(w3cNode);
            if (leftNodesAsSet.contains(myNodeR)){
                return true;
            }
        }
        return false;
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
        return xqLeft.toString()+new String[]{"","=","=="," eq "," is "}[eqOpType]+xqRight.toString();
    }

    private static class MyNode{
        /*
            Here, we should use our own Node class,
            Because the equals(Object o) method of w3c.Node is really stupid
            It returns false when the content of two nodes are the same, but from different place of xml file
         */
    }

    private static class MyStringNode extends MyNode{
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

    private static class MyElementNode extends MyNode{
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
