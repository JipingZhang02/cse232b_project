/*
package edu.ucsd.cse232b.expression.singleExpr;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.util.Consts;
import edu.ucsd.cse232b.util.Util;
import org.w3c.dom.Node;

import java.util.List;

public abstract class UnaryExpr implements Expression {
    public abstract List<Node> evaluateDSL(List<Node> input) throws Exception;

    public abstract List<Node> evaluateSSL(List<Node> input) throws Exception;

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        if (input.slashStatus== Consts.DOUBLE_SLASH){
            return new EvalResult(Util.removeRedaduntElements(evaluateDSL(Util.findAllChildrenNodes(input.nodes))),Consts.NONE);
        } else {
            return new EvalResult(evaluateSSL(input),Consts.NONE);
        }
    }
}
*/
