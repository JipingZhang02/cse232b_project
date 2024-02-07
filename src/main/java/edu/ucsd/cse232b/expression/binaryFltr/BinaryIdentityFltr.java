package edu.ucsd.cse232b.expression.binaryFltr;

import edu.ucsd.cse232b.expression.Expression;
import org.w3c.dom.Node;
import java.util.ArrayList;
import java.util.List;

public class BinaryIdentityFltr extends BinaryFltr {

    public BinaryIdentityFltr(Expression leftRp, Expression rightRp) {
        super(leftRp, rightRp);
    }

    @Override
    protected boolean compare(Node n1, Node n2) {
        return n1.isSameNode(n2);
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> resList = new ArrayList<>();
        for (Node n : inputNodes) {
            List<Node> singleNodeList = new ArrayList<>();
            singleNodeList.add(n);

            List<Node> left = this.leftRp.evaluate(singleNodeList);
            List<Node> right = this.rightRp.evaluate(singleNodeList);

            boolean matchFound = left.stream().anyMatch(leftNode ->
                    right.stream().anyMatch(rightNode -> compare(leftNode, rightNode)));

            if (matchFound) {
                resList.add(n);
            }
        }
        return resList;
    }
}
