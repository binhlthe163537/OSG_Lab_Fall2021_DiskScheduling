/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Legion
 */
public class Inputter {

    private final static String ERRM = "Wrong input!";
    private final static String errM_Null = "Input can not be null!";
    private final static String errM_NotAnInteger = "Input is not an integer!";
    private final static String errM_NotAnPositiveInteger = "Input must be a positive integer!";
    private final static String errM_NotMatches = "Please enter the true form ";
    private final static String errM_NotInRange = "Please enter number in range";

    /**
     *
     * @param msg
     * @param isEmpty
     * @return
     */
    public static String inputString(String msg, boolean isEmpty) {
        Scanner sc = new Scanner(System.in);
        String result;
        while (true) {
            try {
                System.out.print(msg);
                result = sc.nextLine();
                if (result.replaceAll("\\s+", "").isEmpty()) {
                    if (isEmpty) {
                        return null;
                    } else {
                        System.err.println(errM_Null);
                    }
                } else {
                        return result;
                    }
                } catch (Exception e) {
                System.err.println(ERRM);
            }
        }
    }

    /**
     *
     * @param msg
     * @param isNegative
     * @return
     */
    public static int inputInteger(String msg, boolean isNegative) {
        int result;
        while (true) {
            try {
                result = Integer.parseInt(inputString(msg, false));
                if (result < 0) {
                    if (isNegative) {
                        return result;
                    } else {
                        System.err.println(errM_NotAnPositiveInteger);
                    }
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println(errM_NotAnInteger);
            }
        }
    }

    //input id in form as regex
    /**
     *
     * @param msg
     * @param regex
     * @return
     */
    public static String inputId(String msg, String regex) {
        String result;
        while (true) {
            result = Validation.Inputter.inputString(msg, false);
            if (result.matches(regex)) {
                return result;
            } else {
                System.err.println(errM_NotMatches + regex) ;
            }
        }
    }

    /**
     *
     * @param s
     * @return
     */
    public static String normalize(String s) {
        StringTokenizer stk = new StringTokenizer(s, " ");
        String result = stk.nextToken();
        while (stk.hasMoreElements()) {
            result += " " + stk.nextToken();
        }
        return result;
    }

    /**
     *
     * @param msg
     * @param min
     * @param max
     * @return
     */
    public static int inputIntegerInRange(String msg, int min, int max) {
        int result;
        while (true) {
            try {
                result = Integer.parseInt(inputString(msg, false));
                if (result >= min && result <= max) {
                    return result;
                } else {
                    System.err.println(errM_NotInRange);
                }
            } catch (Exception e) {
                System.err.println(errM_NotAnInteger);
            }
        }
    }
}