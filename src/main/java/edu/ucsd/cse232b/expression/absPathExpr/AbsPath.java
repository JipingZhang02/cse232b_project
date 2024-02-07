package edu.ucsd.cse232b.expression.absPathExpr;

import edu.ucsd.cse232b.expression.Expression;

public abstract class AbsPath implements Expression{
    protected final Expression relPath;
    private final String fileName;

    public AbsPath(String fileName,Expression relPath) {
        this.fileName = fileName;
        this.relPath = relPath;
    }

    public String getFileName() {
        return fileName;
    }
}
