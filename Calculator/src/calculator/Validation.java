/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Validation {

    private final Scanner IN = new Scanner(System.in);
    private final String OPERATOR = "[/*\\-+=^]{1}";

    public String checkInputString() {
        while (true) {
            String result = IN.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
                System.out.print("Try again: ");
            } else {
                return result;
            }
        }
    }

    public int checkInt(String msg, int min, int max) {
        int ret;
        System.out.print(msg);
        while (true) {
            try {
                ret = Integer.parseInt(IN.nextLine().trim());
                if (ret >= min && ret <= max) {
                    break;
                } else {
                    System.err.print("Out of range! please enter in range "
                            + "[" + min + "," + max + "]: ");
                }
            } catch (NumberFormatException e) {
                System.err.print("Must enter a number: ");
            }
        }
        return ret;
    }


    public double checkDouble(String msg, double min, double max) {
        double ret;
        System.out.print(msg);
        while (true) {
            try {
                ret = Double.parseDouble(IN.nextLine().trim());
                if (ret >= min && ret <= max) {
                    break;
                } else {
                    System.err.print("Out of range! please enter in range "
                            + "[" + min + "," + max + "]: ");
                }
            } catch (NumberFormatException e) {
                System.err.print("Must enter a real number: ");
            }
        }
        return ret;
    }
    
    public String checkOperator(String msg) {
        String ret;
        while (true) {
            System.out.print(msg);
            ret = checkInputString();
            if (ret.matches(OPERATOR)) {
                break;
            } else {
                System.err.println("Must enter ONE +, -, *, /or ^.");
            }
        }
        return ret;
    }

//op1 is the letter type to return true, op2 for false

    public boolean checkTF(String msg, String op1, String op2) {
        while (true) {
            System.out.print(msg);
            String result = checkInputString();
            if (result.length() == 1) {
                if (result.equalsIgnoreCase(op1)) {
                    return true;
                } else {
                    if (result.equalsIgnoreCase(op2)) {
                        return false;
                    }
                }
            }
            System.err.println("Try again");
        }
    }

}
