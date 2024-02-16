package edu.ucsd.cse232b.expression.singleExpr;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.common.Consts;
import edu.ucsd.cse232b.common.Util;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class TagExpr implements Expression {
    private final String tagName;

    public TagExpr(String tagName) {
        this.tagName = tagName;
    }

/*    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> res = new ArrayList<>();
        for (Node node:inputNodes){
            if (node.getNodeType()==Node.ELEMENT_NODE&&node.getNodeName().equals(tagName)){
                res.add(node);
            }
        }
        return res;
    }*/

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        List<Node> inputNodes = null;
        if (input.slashStatus== Consts.DOUBLE_SLASH){
            inputNodes = Util.findAllChildrenNodes(input.nodes);
        } else{
            inputNodes = Util.findDirectChildrenNodes(input.nodes);
        }
        List<Node> res = new ArrayList<>();
        for (Node node:inputNodes){
            if (node.getNodeType()==Node.ELEMENT_NODE&&node.getNodeName().equals(tagName)){
                res.add(node);
            }
        }
        return new EvalResult(res,Consts.NONE);
    }
}
