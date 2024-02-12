package edu.ucsd.cse232b.expression.binaryFltr;

import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.util.Util;
import org.w3c.dom.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryEqualsFltr extends BinaryFltr {

    public BinaryEqualsFltr(Expression leftRp, Expression rightRp) {
        super(leftRp, rightRp);
    }

    @Override
    protected boolean compare(Node n1, Node n2) {
        return n1.isEqualNode(n2);
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> resultList = new ArrayList<>();
        for (Node n : inputNodes) {
            List<Node> singleNodeList = Util.findDirectChildrenNodes(Arrays.asList(n));

            List<Node> left = this.leftRp.evaluate(singleNodeList);
            List<Node> right = this.rightRp.evaluate(singleNodeList);

            boolean matchFound = left.stream().anyMatch(leftNode ->
                    right.stream().anyMatch(rightNode -> compare(leftNode, rightNode)));

            if (matchFound) {
                resultList.add(n);
            }
        }
        return resultList;
    }
}

