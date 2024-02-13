package edu.ucsd.cse232b.expression.singleFltr;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.util.Consts;
import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;

public class SingleFltr implements Expression {

    private final Expression rp;

    public SingleFltr(Expression rp) {

        Objects.requireNonNull(rp, "Relative path (rp) is NULL!");

        this.rp = rp.removeLeftmostSelfExpr();
    }

/*    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> resultList = new ArrayList<>();
        for (Node n : inputNodes) {

            List<Node> rpResult = rp.evaluate(n.getChildNodes());

            if (!rpResult.isEmpty()) {
                resultList.add(n);
            }
        }
        return resultList;
    }*/

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        List<Node> resultList = new ArrayList<>();
        for (Node node: input.nodes){
            List<Node> singleNodeList = Arrays.asList(node);
            if (!rp.evaluate(new EvalResult(singleNodeList,input.slashStatus)).nodes.isEmpty()){
                resultList.add(node);
            }
        }
        return new EvalResult(resultList, Consts.NONE);
    }
}
