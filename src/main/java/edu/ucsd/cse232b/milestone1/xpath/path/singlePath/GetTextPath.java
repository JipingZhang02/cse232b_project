package edu.ucsd.cse232b.milestone1.xpath.path.singlePath;

import edu.ucsd.cse232b.common.Util;
import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone1.xpath.XPath;
import edu.ucsd.cse232b.common.SlashStatus;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class GetTextPath implements XPath {
/*    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> res = new ArrayList<>();
        for (Node node:inputNodes){
            if (node.getNodeType()==Node.TEXT_NODE){
                res.add(node);
            }
        }
        return res;
    }*/

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        if (input.slashStatus== SlashStatus.DOUBLE_SLASH){
            throw new IllegalArgumentException();
        }
        List<Node> res = new ArrayList<>();
        for (Node node:input.nodes){
            for (Node childNode: Util.toJavaBuiltinList(node.getChildNodes())) {
                if (childNode.getNodeType() == Node.TEXT_NODE) {
                    res.add(childNode);
                }
            }
        }
        return new EvalResult(res, SlashStatus.NONE);
    }

    @Override
    public String toString(){
        return "text()";
    }
}
