package edu.ucsd.cse232b.milestone1.xpath.path.singlePath;

import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone1.xpath.XPath;
import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.common.Util;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class TagPath implements XPath {
    private final String tagName;

    public TagPath(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        List<Node> inputNodes = null;
        if (input.slashStatus== SlashStatus.DOUBLE_SLASH){
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
        return new EvalResult(res, SlashStatus.NONE);
    }

    @Override
    public String toString(){
        return tagName;
    }
}
