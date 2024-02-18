package edu.ucsd.cse232b.common;

public class SlashStatus {
    // I just don't want to use enum here
    public static final int NONE = 0;
    public static final int SINGLE_SLASH = 1;
    public static final int DOUBLE_SLASH = 2;

    public static String toString(int slashStatus){
        String res = "";
        for (int i = 0; i < slashStatus; i++) {
            res+="/";
        }
        return res;
    }
}
