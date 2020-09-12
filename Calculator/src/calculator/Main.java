/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author pc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Managing m = new Managing();
        while (true) {
            System.out.println("=======Calculator Program======\n"
                    + "1. Normal Calculator\n"
                    + "2. BMI calculator\n"
                    + "3. Exit");
            int choice = m.val.checkInt("Please choice one option: ", 1, 3);
            switch (choice) {
                case 1: {
                    m.normalCal();
                    break;
                }
                case 2: {
                    m.BMICal();
                    break;
                }
                case 3: {
                    return;
                }
            }
        }
    }
}
