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
public class Managing {

    public Validation val = new Validation();

    public int welcome() {
        System.out.println("=============Handy Expense Program===============");
        System.out.println("1. Add an expense\n"
                + "2. Display all expenses\n"
                + "3. Remove an expense\n"
                + "4. Exit");
        int option = val.checkInt("Enter your selection: ", 1, 4);
        return option;
    }

    public void addExpenses(ArrayList<Expense> expenses, int id) {
        System.out.println("=================Add an expense==================");
        System.out.print("Enter date: ");
        String date = val.checkDate();
//        System.out.println("Enter amount: ");
        double amount = val.checkDouble("Enter amount: ", 0, Double.POSITIVE_INFINITY);
        System.out.print("Enter content: ");
        String content = val.checkInputString();
        expenses.add(new Expense(id, date, amount, content));
    }

    public void displayAllExpense(ArrayList<Expense> expenses) {
        if (expenses.isEmpty()) {
            System.err.println("No expense to display");
            return;
        }
        System.out.println("=============Display all expenses================");
        System.out.format("%-5s%15s%10s%20s\n", "ID", "Date", "Amount", "Content");
        double total = 0;
        for (Expense expense : expenses) {
            System.out.format("%5d%15s%10.2f%20s\n",
                    expense.getId(), expense.getDate(), expense.getAmount(), expense.getContent());
            total += expense.getAmount();
        }
        System.out.println("Total :" + total);
    }

    public void removeAnExpense(ArrayList<Expense> expenses) {
        if (expenses.isEmpty()) {
            System.err.println("No expeneses");
            return;
        }
        System.out.println("================Delete an expense================");
//        System.out.print("Enter id: ");
        int id = val.checkInt("Enter id: ", 1, expenses.size());
        int toRemove = val.isIdExists(expenses, id);
        if (toRemove != -1) {
            expenses.remove(toRemove);
            System.out.println("Delete an expense successfully");
        } else {
            System.out.println("Delete an expense fail");
        }
    }
}
