package edu.ucsd.cse232b.expression.binaryFltr;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.util.Consts;
import edu.ucsd.cse232b.util.Util;
import org.w3c.dom.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryConstEqualsFltr extends BinaryFltr {

    private final String constString;

    public BinaryConstEqualsFltr(Expression leftRp, String constString) {
        super(leftRp, null);
        this.constString = constString;
    }

/*    @Override
    protected boolean compare(Node n1, Node n2) {
        return n1.getNodeValue() != null && n1.getNodeValue().equals(constString);
    }*/

/*    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> resultList = new ArrayList<>();
        for (Node n : inputNodes) {
            List<Node> singleNodeList = Util.findDirectChildrenNodes(Arrays.asList(n));

            List<Node> leftResults = this.leftRp.evaluate(singleNodeList);
            boolean matchFound = false;

            for (Node leftNode : leftResults) {
                if (compare(leftNode, null)) {
                    matchFound = true;
                    break;
                }
            }

            if (matchFound) {
                resultList.add(n);
            }
        }
        return resultList;
    }*/

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        List<Node> resultList = new ArrayList<>();
        for (Node node:input.nodes){
            boolean matchFound = false;
            List<Node> singleNodeList = Arrays.asList(node);
            EvalResult leftRes = leftRp.evaluate(new EvalResult(singleNodeList, input.slashStatus));
            for (Node leftNode:leftRes.nodes){
                if (leftNode!=null&&leftNode.getNodeValue().equals(constString)){
                    matchFound = true;
                    break;
                }
            }
            if (matchFound){
                resultList.add(node);
            }
        }
        return new EvalResult(resultList, Consts.NONE);
    }
}
