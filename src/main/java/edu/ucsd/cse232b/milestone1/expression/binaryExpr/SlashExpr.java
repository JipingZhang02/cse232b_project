package edu.ucsd.cse232b.milestone1.expression.binaryExpr;

import edu.ucsd.cse232b.common.SlashStatus;
import edu.ucsd.cse232b.milestone1.expression.EvalResult;
import edu.ucsd.cse232b.milestone1.expression.Expression;

public class SlashExpr extends BinaryExpr{
    private final int slashStatus;

    public SlashExpr(Expression left, Expression right, int slashStatus) {
        super(left, right);
        this.slashStatus = slashStatus;
    }

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        EvalResult leftRes = left.evaluate(input);
        leftRes.slashStatus = slashStatus;
        return right.evaluate(leftRes);
    }

    @Override
    public String toString(){
        return left.toString()+ SlashStatus.toString(slashStatus)+right.toString();
    }
}
