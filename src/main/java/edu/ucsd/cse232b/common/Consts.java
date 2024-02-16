package edu.ucsd.cse232b.common;

import java.util.Arrays;
import java.util.List;

// this file consists of all constants used in project
public class Consts {
    // I just don't want to use enum here
    public static final int NONE = 0;
    public static final int SINGLE_SLASH = 1;
    public static final int DOUBLE_SLASH = 2;

    public static final List<String> DEFAULT_XML_FILE_PATHS = Arrays.asList("./j_caesar.xml","./test.xml");
}
