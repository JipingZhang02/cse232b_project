package edu.ucsd.cse232b.milestone1.xpath.fltr.singleFltr;

import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone1.xpath.XPath;
import edu.ucsd.cse232b.common.SlashStatus;
import org.w3c.dom.Node;

import java.util.*;

public class SingleFltr implements XPath {

    private final XPath rp;

    public SingleFltr(XPath rp) {

        Objects.requireNonNull(rp, "Relative path (rp) is NULL!");

        this.rp = rp.removeLeftmostSelfExpr();
    }


    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        List<Node> resultList = new ArrayList<>();
        for (Node node: input.nodes){
            List<Node> singleNodeList = Arrays.asList(node);
            if (!rp.evaluate(new EvalResult(singleNodeList,input.slashStatus)).nodes.isEmpty()){
                resultList.add(node);
            }
        }
        return new EvalResult(resultList, SlashStatus.NONE);
    }

    @Override
    public String toString(){
        return rp.toString();
    }
}
