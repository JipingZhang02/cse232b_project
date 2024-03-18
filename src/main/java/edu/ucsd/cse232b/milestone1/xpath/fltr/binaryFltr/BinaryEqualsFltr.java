package edu.ucsd.cse232b.milestone1.xpath.fltr.binaryFltr;

import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone1.xpath.XPath;
import edu.ucsd.cse232b.common.SlashStatus;
import org.w3c.dom.Node;

import java.util.*;

public class BinaryEqualsFltr extends BinaryFltr {

    public BinaryEqualsFltr(XPath leftRp, XPath rightRp) {
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
        return new EvalResult(resultList, SlashStatus.NONE);
    }

    @Override
    public String toString(){
        return leftRp.toString()+"="+rightRp.toString();
    }
}

