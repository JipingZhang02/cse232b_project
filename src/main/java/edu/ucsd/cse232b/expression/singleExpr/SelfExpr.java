package edu.ucsd.cse232b.expression.singleExpr;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.common.Util;

public class SelfExpr implements Expression {
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
