package edu.ucsd.cse232b.milestone1.expression;

public interface Expression {
    EvalResult evaluate(EvalResult input) throws Exception;

    default Expression removeLeftmostSelfExpr(){
        return this;
    }
}
