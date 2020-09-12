/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidate;

import java.util.ArrayList;
import java.util.Scanner;
import model.Candidate;

/**
 *
 * @author pc
 */
public class Validation {

    private final Scanner IN = new Scanner(System.in);

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

    public String checkPhoneNumber() {
        String phoneReg = "^[0-9]{10}$";
        while (true) {
            String result = IN.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
                System.out.print("Try again: ");
            } else if (result.matches(phoneReg)) {
                return result;
            } else {
                System.err.println("Please input right phone number!");
                System.out.print("Try again: ");
            }
        }
    }

    public String checkEmail() {
        String emailReg = "^[A-Za-z]+[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,3}$";
        while (true) {
            String result = IN.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
                System.out.print("Try again: ");
            } else if (result.matches(emailReg)) {
                return result;
            } else {
                System.err.println("Please input right email!");
                System.out.print("Try again: ");
            }
        }
    }

    public String checkGraduationRank() {
        while (true) {
            String result = IN.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
                System.out.print("Try again: ");
            } else if (result.equalsIgnoreCase("exellent")
                    || result.equalsIgnoreCase("good")
                    || result.equalsIgnoreCase("fair")
                    || result.equalsIgnoreCase("poor")) {
                return result;
            } else {
                System.err.println("Please input exellent, good, fair or poor");
                System.out.print("Try again: ");
            }
        }
    }

    public int isExists(ArrayList<Candidate> cadidates, String id) {
        for (int i = 0; i < cadidates.size(); i++) {
            if (cadidates.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
