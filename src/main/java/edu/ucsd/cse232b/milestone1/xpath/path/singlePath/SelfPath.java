package edu.ucsd.cse232b.milestone1.xpath.path.singlePath;

import edu.ucsd.cse232b.common.EvalResult;
import edu.ucsd.cse232b.milestone1.xpath.XPath;
import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.common.Util;

public class SelfPath implements XPath {
    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        if (input.slashStatus== SlashStatus.DOUBLE_SLASH){
            return new EvalResult(input.nodes, SlashStatus.NONE);
        } else {
            return new EvalResult(Util.findAllChildrenNodes(input.nodes), SlashStatus.NONE);
        }
    }

    @Override
    public String toString(){
        return ".";
    }
}
