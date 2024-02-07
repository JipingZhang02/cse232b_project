package edu.ucsd.cse232b.expression.absPathExpr;

import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.util.Util;
import org.w3c.dom.Node;

import java.util.List;

public class AbsPathDSL extends AbsPath {
    public AbsPathDSL(String fileName, Expression relPath) {
        super(fileName, relPath);
    }

    @Override
    public List<Node> evaluate(List<Node> inputNodes) throws Exception {
        return Util.removeRedaduntElements(relPath.evaluate(Util.findAllChildrenNodes(inputNodes)));
    }
}
