/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpbank;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Validation {

    private final Scanner IN = new Scanner(System.in);
    private final String ACC_NUM = "^[0-9]{10}$";
    private final String PASSWORD = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,31}$";

    //check user input number limit and type
    public int checkInt(String msg, int min, int max) {
        int ret;
        while (true) {
            System.out.print(msg);
            try {
                ret = Integer.parseInt(IN.nextLine());
                if (ret >= min && ret <= max) {
                    break;
                } else {
                    System.err.println("Out of range! Please input in range "
                            + "[" + min + ", " + max + "]: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter a number!");
                System.out.print("Try again: ");
            }
        }
        return ret;
    }

    //check user input string
    public String checkInputString() {
        //loop until correct
        while (true) {
            String result = IN.nextLine().trim();
            if (result.isEmpty()) {
                System.err.print("Not empty. Enter again: ");
            } else {
                return result;
            }
        }
    }

    public void checkAccNumber(ResourceBundle bundle) {
        while (true) {
            System.out.print(bundle.getString("account"));
            String result = checkInputString();
            if (result.matches(ACC_NUM)) {
                break;
            } else {
                System.err.println(bundle.getString("wrong.account"));
            }
        }
    }

    public void checkPass(ResourceBundle bundle) {
        while (true) {
            System.out.print(bundle.getString("password"));
            String result = checkInputString();
            if (result.matches(PASSWORD)) {
                break;
            } else {
                System.err.println(bundle.getString("wrong.password"));
            }
        }
    }

    public void checkCaptcha(ResourceBundle bundle, String captcha) {
        System.out.println(bundle.getString("captcha") + captcha);
        while (true) {
            System.out.print(bundle.getString("captchaInput"));
            String result = checkInputString();
            if (captcha.contains(result)) {
                break;
            } else {
                System.err.println(bundle.getString("wrong.captcha"));
            }
        }
    }
}
