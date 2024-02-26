package edu.ucsd.cse232b;

import edu.ucsd.cse232b.xpath.XPath;
import edu.ucsd.cse232b.xquery.XQuery;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length >= 2) {
            if (args[0].equals("-mode")) {
                String[] argsReal = Arrays.copyOfRange(args, 2, args.length);
                switch (args[1]) {
                    case "xpath":
                        XPath.main(argsReal);
                        return;
                    case "xquery":
                        XQuery.main(argsReal);
                        return;
                }
            }
        }

        //default
        XQuery.main(args);
    }
}
