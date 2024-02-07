package edu.ucsd.cse232b.expression.absPathExpr;

import edu.ucsd.cse232b.expression.Expression;
import org.w3c.dom.Node;

import java.util.List;

public class AbsPathSL extends AbsPath {
    public AbsPathSL(String fileName, Expression relPath) {
        super(fileName, relPath);
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        return relPath.evaluate(inputNodes);
    }
}
