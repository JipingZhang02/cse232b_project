package edu.ucsd.cse232b;

import edu.ucsd.cse232b.xpath.XPath;
import edu.ucsd.cse232b.xquery.XQuery;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("program running with args: " + Arrays.toString(args));
        if (args.length >= 2) {
            if (args[0].equals("-mode")) {
                String[] argsTruncated = Arrays.copyOfRange(args, 2, args.length);
                switch (args[1]) {
                    case "xpath":
                        XPath.main(argsTruncated);
                        return;
                    case "xquery":
                        XQuery.main(argsTruncated);
                        return;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }

        //default
        XQuery.main(args);
    }
}