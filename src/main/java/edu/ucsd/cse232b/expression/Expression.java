package edu.ucsd.cse232b.expression;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public interface Expression {
    EvalResult evaluate(EvalResult input) throws Exception;

    default Expression removeLeftmostSelfExpr(){
        return this;
    }
}
