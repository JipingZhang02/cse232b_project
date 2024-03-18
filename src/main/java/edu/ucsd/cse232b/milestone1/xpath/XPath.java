package edu.ucsd.cse232b.milestone1.xpath;

import edu.ucsd.cse232b.common.EvalResult;

public interface XPath {
    EvalResult evaluate(EvalResult input) throws Exception;

    default XPath removeLeftmostSelfExpr(){
        return this;
    }
}
