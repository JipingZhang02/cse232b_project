package edu.ucsd.cse232b.expression.binaryFltr;

import edu.ucsd.cse232b.expression.Expression;
import org.w3c.dom.Node;
import java.util.ArrayList;
import java.util.List;

public class BinaryConstEqualsFltr extends BinaryFltr {

    private final String constString;

    public BinaryConstEqualsFltr(Expression leftRp, String constString) {
        super(leftRp, null);
        this.constString = constString;
    }

    @Override
    protected boolean compare(Node n1, Node n2) {
        return n1.getNodeValue() != null && n1.getNodeValue().equals(constString);
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> resultList = new ArrayList<>();
        for (Node n : inputNodes) {
            List<Node> singleNodeList = new ArrayList<>();
            singleNodeList.add(n);

            List<Node> leftResults = this.leftRp.evaluate(singleNodeList);
            boolean matchFound = false;

            for (Node leftNode : leftResults) {
                if (compare(leftNode, null)) {
                    matchFound = true;
                    break;
                }
            }

            if (matchFound) {
                resultList.add(n);
            }
        }
        return resultList;
    }
}
