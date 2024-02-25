package edu.ucsd.cse232b.milestone3.xQueryRewriter;

import edu.ucsd.cse232b.xquery.QueryBuilder;
import edu.ucsd.cse232b.xquery.XQuery;

import java.io.IOException;

public class TestQueryRewriter {
    public static void main(String[] args) throws IOException {
        String xquery = XQuery.readQuery("./xquery.txt");
        System.out.println(QueryRewriter.rewriteQuery(xquery));
    }
}
