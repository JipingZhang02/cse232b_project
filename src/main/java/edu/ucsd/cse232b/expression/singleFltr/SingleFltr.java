package edu.ucsd.cse232b.expression.singleFltr;

import edu.ucsd.cse232b.expression.Expression;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SingleFltr implements Expression {

    final private Expression rp;

    public SingleFltr(Expression rp) {

        Objects.requireNonNull(rp, "Relative path (rp) is NULL!");

        this.rp = rp;
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> resultList = new ArrayList<>();
        for (Node n : inputNodes) {

            List<Node> rpResult = evaluateRelativePath(rp, n);

            if (!rpResult.isEmpty()) {
                resultList.add(n);
            }
        }
        return resultList;
    }

    // A helper method to evaluate the relative path expression on a given node
    private List<Node> evaluateRelativePath(Expression rp, Node n) throws Exception {
        return rp.evaluate(new ArrayList<>(Collections.singletonList(n)));
    }

}
