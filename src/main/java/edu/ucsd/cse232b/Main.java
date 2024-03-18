package edu.ucsd.cse232b;

import edu.ucsd.cse232b.milestone1.Ms1Main;
import edu.ucsd.cse232b.milestone2.Ms2Main;
import edu.ucsd.cse232b.milestone3.Ms3Main;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("program running with args: " + Arrays.toString(args));
        if (args.length >= 2) {
            if (args[0].equals("-mode")) {
                String[] argsTruncated = Arrays.copyOfRange(args, 2, args.length);
                switch (args[1]) {
                    case "xpath":
                        Ms1Main.main(argsTruncated);
                        return;
                    case "xquery":
                        Ms2Main.main(argsTruncated);
                        return;
                    case "ms3":
                        Ms3Main.main(argsTruncated);
                        return;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }

        //default
        Ms3Main.main(args);
    }
}
