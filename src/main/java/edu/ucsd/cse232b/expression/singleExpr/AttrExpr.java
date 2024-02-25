package edu.ucsd.cse232b.expression.singleExpr;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.common.SlashStatus;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class AttrExpr implements Expression {
    private final String attrName;

    public AttrExpr(String attrName) {
        if (attrName.startsWith("@")){
            System.out.printf("Warning: got an unremoved '@' when constructing AttrExpr(attrName=%s)\n",attrName);
            attrName = attrName.substring(1);
            System.out.println("    The @ is auto removed");
        }
        this.attrName = attrName;
    }

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        if (input.slashStatus== SlashStatus.DOUBLE_SLASH){
            throw new IllegalArgumentException();
        }
        List<Node> res = new ArrayList<>();
        for (Node node:input.nodes){
            Node attrNode = node.getAttributes().getNamedItem(attrName);
            if (attrNode!=null){
                res.add(attrNode);
            }
        }
        return new EvalResult(res, SlashStatus.NONE);
    }

    @Override
    public String toString(){
        return "@"+attrName+"()";
    }
}
