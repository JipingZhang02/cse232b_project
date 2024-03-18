package edu.ucsd.cse232b.milestone1.xpath.fltr.binaryFltr;

import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone1.xpath.XPath;
import edu.ucsd.cse232b.common.SlashStatus;
import org.w3c.dom.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryConstEqualsFltr extends BinaryFltr {

    private final String constString;

    public BinaryConstEqualsFltr(XPath leftRp, String constString) {
        super(leftRp, null);
        this.constString = constString;
    }

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        List<Node> resultList = new ArrayList<>();
        for (Node node:input.nodes){
            boolean matchFound = false;
            List<Node> singleNodeList = Arrays.asList(node);
            EvalResult leftRes = leftRp.evaluate(new EvalResult(singleNodeList, input.slashStatus));
            for (Node leftNode:leftRes.nodes){
                if (leftNode==null){
                    continue;
                }
                String nodeStrVal = leftNode.getNodeValue();
                if (nodeStrVal.equals(constString)){
                    matchFound = true;
                    break;
                }
            }
            if (matchFound){
                resultList.add(node);
            }
        }
        return new EvalResult(resultList, SlashStatus.NONE);
    }

    @Override
    public String toString(){
        return leftRp.toString()+"==\""+constString+"\"";
    }
}
