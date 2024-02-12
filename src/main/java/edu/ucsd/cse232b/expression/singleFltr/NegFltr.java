package edu.ucsd.cse232b.expression.singleFltr;

import edu.ucsd.cse232b.expression.Expression;
import org.w3c.dom.Node;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class NegFltr implements Expression {

    private final Expression ft;

    public NegFltr(Expression ft) {
        Objects.requireNonNull(ft, "filter is NULL!");
        this.ft = ft.removeLeftmostSelfExpr();
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        List<Node> nodesToNegate = this.ft.evaluate(inputNodes);

        Set<Node> resultSet = new HashSet<>(inputNodes);
        resultSet.removeAll(nodesToNegate);

        List<Node> resultList = inputNodes.stream()
                .filter(resultSet::contains)
                .collect(Collectors.toList());

        return resultList;
    }

}
