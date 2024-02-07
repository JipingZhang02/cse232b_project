package edu.ucsd.cse232b.expression.binaryFltr;

import edu.ucsd.cse232b.expression.Expression;
import org.w3c.dom.Node;
import java.util.List;
import java.util.Objects;

public abstract class BinaryFltr implements Expression {

    protected final Expression leftRp;
    protected final Expression rightRp;

    public BinaryFltr(Expression leftRp, Expression rightRp) {
        Objects.requireNonNull(leftRp, "leftRp is NULL!");
        Objects.requireNonNull(rightRp, "rightRp is NULL!");

        this.leftRp = leftRp;
        this.rightRp = rightRp;
    }

    protected abstract boolean compare(Node n1, Node n2);

    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        throw new UnsupportedOperationException("Evaluate method needs to be implemented.");
    }
}

