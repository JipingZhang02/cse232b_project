package edu.ucsd.cse232b.query.binaryQuery;

import edu.ucsd.cse232b.expression.Expression;
import edu.ucsd.cse232b.query.Query;

public abstract class XQSlashRP implements Query{
    protected final Query query;
    protected final Expression relPath;

    public XQSlashRP(Query query, Expression relPath) {
        this.query = query;
        this.relPath = relPath;
    }
}
