package edu.ucsd.cse232b.expression.binaryFltr;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.util.Consts;
import edu.ucsd.cse232b.util.Util;
import org.w3c.dom.Node;

import java.util.*;

public class BinaryEqualsFltr extends BinaryFltr {

    public BinaryEqualsFltr(Expression leftRp, Expression rightRp) {
        super(leftRp, rightRp);
    }

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        List<Node> resultList = new ArrayList<>();
        for (Node node:input.nodes){
            List<Node> singleNodeList = Arrays.asList(node);
            EvalResult leftRes = leftRp.evaluate(new EvalResult(singleNodeList, input.slashStatus));
            EvalResult rightRes = rightRp.evaluate(new EvalResult(singleNodeList,input.slashStatus));
            Set<Node> rightResAsSet = new HashSet<>(rightRes.nodes);
            for (Node lNode:leftRes.nodes){
                if (rightResAsSet.contains(lNode)){
                    resultList.add(node);
                    break;
                }
            }
        }
        return new EvalResult(resultList, Consts.NONE);
    }

    /*    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> resultList = new ArrayList<>();
        for (Node n : inputNodes) {
            List<Node> singleNodeList = Util.findDirectChildrenNodes(Arrays.asList(n));

            List<Node> left = this.leftRp.evaluate(singleNodeList);
            List<Node> right = this.rightRp.evaluate(singleNodeList);

            boolean matchFound = left.stream().anyMatch(leftNode ->
                    right.stream().anyMatch(rightNode -> compare(leftNode, rightNode)));

            if (matchFound) {
                resultList.add(n);
            }
        }
        return resultList;
    }*/
}

