/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workermanagement;

import entities.Worker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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

    public String checkDate() {
        while (true) {
            try {
                SimpleDateFormat sdfm = new SimpleDateFormat("dd-MM-yyyy");
                sdfm.setLenient(false);
                String date = checkInputString();
                Date javaDate = sdfm.parse(date);
                return new SimpleDateFormat("dd-MMM-yyyy").format(javaDate);
            } catch (ParseException e) {
                System.err.println("please input right date format (dd/MM/yyyy)");
                System.out.print("re-input: ");
            }
        }
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

    public int isIdExists(ArrayList<Worker> workers, String id) {
        for (Worker worker : workers) {
            if (worker.getId().equals(id)) {
                return workers.indexOf(worker);
            }
        }
        return -1;
    }
}
