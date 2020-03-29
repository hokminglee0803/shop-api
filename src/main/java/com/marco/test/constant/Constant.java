package com.marco.test.constant;

import java.util.HashMap;

public class Constant {
    public static final HashMap<Character, Character> alphabetConversion = new HashMap<>();

    static {
        alphabetConversion.put('A','0');
        alphabetConversion.put('B','1');
        alphabetConversion.put('C','2');
        alphabetConversion.put('D','3');
        alphabetConversion.put('E','4');
        alphabetConversion.put('F','5');
        alphabetConversion.put('G','6');
        alphabetConversion.put('H','7');
        alphabetConversion.put('I','8');
        alphabetConversion.put('J','9');

        alphabetConversion.put('K','0');
        alphabetConversion.put('L','1');
        alphabetConversion.put('M','2');
        alphabetConversion.put('N','3');
        alphabetConversion.put('O','4');
        alphabetConversion.put('P','5');
        alphabetConversion.put('Q','6');
        alphabetConversion.put('R','7');
        alphabetConversion.put('S','8');
        alphabetConversion.put('T','9');

        alphabetConversion.put('U','0');
        alphabetConversion.put('V','1');
        alphabetConversion.put('W','2');
        alphabetConversion.put('X','3');
        alphabetConversion.put('Y','4');
        alphabetConversion.put('Z','5');
    }

    public static final char[] number = {'0','1','2','3','4','5','6','7','8','9'};

}
