package edu.ucsd.cse232b.expression.absPathExpr;

import edu.ucsd.cse232b.expression.EvalResult;
import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.util.Consts;
import edu.ucsd.cse232b.util.Util;
import org.w3c.dom.Node;

import java.util.List;

public class AbsPathDSL extends AbsPath {
    public AbsPathDSL(String fileName, Expression relPath) {
        super(fileName, relPath);
    }

    @Override
    public EvalResult evaluate(EvalResult input) throws Exception {
        return relPath.evaluate(new EvalResult(input.nodes,Consts.DOUBLE_SLASH));
    }
}
