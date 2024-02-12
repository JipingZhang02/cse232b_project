package edu.ucsd.cse232b.expression.singleExpr;

import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.util.Util;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class AttrExpr implements Expression {
    private final String attrName;

    public AttrExpr(String attrName) {
        if (attrName.startsWith("@")){
            attrName = attrName.substring(1);
        }
        this.attrName = attrName;
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> i2 = new ArrayList<>();
        for(Node node:inputNodes){
            Node parent = node.getParentNode();
            if (!(parent instanceof Document)){
                i2.add(parent);
            }
        }
        i2 = Util.removeRedaduntElements(i2);
        List<Node> res = new ArrayList<>();
        for (Node node:i2){
            Node attrNode = node.getAttributes().getNamedItem(attrName);
            if (attrNode!=null){
                res.add(attrNode);
            }
        }
        return res;
    }
}
