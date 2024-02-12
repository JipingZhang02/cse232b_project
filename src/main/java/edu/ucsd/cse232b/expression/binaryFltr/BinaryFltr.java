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
        this.leftRp = leftRp.removeLeftmostSelfExpr();
        if (rightRp!=null) {
            this.rightRp = rightRp.removeLeftmostSelfExpr();
        } else {
            this.rightRp = null;
        }
    }

    protected abstract boolean compare(Node n1, Node n2);
}

