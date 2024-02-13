package edu.ucsd.cse232b.expression.singleExpr;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.util.Consts;
import edu.ucsd.cse232b.util.Util;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

// *
public class StarExpr implements Expression {
/*    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> res = new ArrayList<>();
        for (Node node:inputNodes){
            if (node.getNodeType()==Node.ELEMENT_NODE){
                res.add(node);
            }
        }
        return res;
    }*/

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        if (input.slashStatus== Consts.DOUBLE_SLASH){
            throw new IllegalArgumentException();
        }
        List<Node> res = Util.findDirectChildrenNodes(input.nodes);
        return new EvalResult(Util.removeRedaduntElements(res),Consts.NONE);
    }
}
