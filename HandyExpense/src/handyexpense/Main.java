/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handyexpense;

import entities.Expense;
import java.util.ArrayList;

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
        ArrayList<Expense> expenses = new ArrayList<>();
        int id = 0;
        while (true) {
            int option = m.welcome();
            switch (option) {
                case 1: {
                    m.addExpenses(expenses, ++id);
                    break;
                }
                case 2: {
                    m.displayAllExpense(expenses);
                    break;
                }
                case 3: {
                    m.removeAnExpense(expenses);
                    break;
                }
                case 4: {
                    return;
                }
            }
        }
    }

}
