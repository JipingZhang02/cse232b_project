package edu.ucsd.cse232b.expression.singleExpr;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.common.Util;
import org.w3c.dom.Node;

import java.util.List;

// *
public class StarExpr implements Expression {
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
