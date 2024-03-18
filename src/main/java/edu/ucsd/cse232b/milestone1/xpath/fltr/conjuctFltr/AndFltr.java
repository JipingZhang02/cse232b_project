package edu.ucsd.cse232b.milestone1.xpath.fltr.conjuctFltr;

import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone1.xpath.XPath;
import edu.ucsd.cse232b.common.SlashStatus;
import org.w3c.dom.Node;

import java.util.*;

public class AndFltr extends ConjuctFltr {
    public AndFltr(XPath leftXPath, XPath rightXPath) {
        super(leftXPath, rightXPath);
    }

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        List<Node> leftRes = leftXPath.evaluate(input).nodes;
        List<Node> rightRes = rightXPath.evaluate(input).nodes;
        Set<Node> toSaveSet = new HashSet<>();
        toSaveSet.addAll(leftRes);
        toSaveSet.addAll(rightRes);
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
        return "("+ leftXPath.toString()+" and "+ rightXPath.toString()+")";
    }
}
