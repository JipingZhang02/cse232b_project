package edu.ucsd.cse232b.milestone1.xpath.path.singlePath;

import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone1.xpath.XPath;
import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.common.Util;
import org.w3c.dom.Node;

import java.util.List;

public class StarPath implements XPath {
    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        if (input.slashStatus== SlashStatus.DOUBLE_SLASH){
            throw new IllegalArgumentException();
        }
        List<Node> res = Util.findDirectChildrenNodes(input.nodes);
        return new EvalResult(Util.removeRedaduntElements(res), SlashStatus.NONE);
    }

    @Override
    public String toString(){
        return "*";
    }
}
