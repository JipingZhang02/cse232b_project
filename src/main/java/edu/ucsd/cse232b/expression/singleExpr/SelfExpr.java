package edu.ucsd.cse232b.expression.singleExpr;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.common.Consts;
import edu.ucsd.cse232b.common.Util;

public class SelfExpr implements Expression {
/*    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> res = new ArrayList<>();
        for(Node node:inputNodes){
            Node parent = node.getParentNode();
            if (!(parent instanceof Document)){
                res.add(parent);
            }
        }
        return Util.removeRedaduntElements(res);
    }*/

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        if (input.slashStatus== Consts.DOUBLE_SLASH){
            return new EvalResult(input.nodes,Consts.NONE);
        } else {
            return new EvalResult(Util.findAllChildrenNodes(input.nodes),Consts.NONE);
        }
    }
}
