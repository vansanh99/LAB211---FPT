/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workermanagement;

import entities.History;
import entities.Worker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

/**
 *
 * @author pc
 */
public class Managing {

    public Validation val = new Validation();

    public int welcome() {
        System.out.println("================Worker Management================");
        System.out.println("1. Add worker\n"
                + "2. Up salary\n"
                + "3. Down salary\n"
                + "4. Display informarion salary\n"
                + "5. Exit");
        int oprion = val.checkInt("Enter your choice: ", 1, 5);
        return oprion;
    }

    public void addWorker(ArrayList<Worker> workers, ArrayList<History> histories) {
        while (true) {
            System.out.print("Enter code: ");
            String code = val.checkInputString();
            if (val.isIdExists(workers, code) != -1) {
                System.err.println("Code exists");
                continue;
            }
            System.out.print("Enter name: ");
            String name = val.checkInputString();
//            System.out.print("Enter age: ");
            int age = val.checkInt("Enter age: ", 18, 50);
//            System.out.println("Enter salary: ");
            double salary = val.checkDouble("Enter salary: ", 0, Double.POSITIVE_INFINITY);
            System.out.print("Enter work locarion: ");
            String workLocation = val.checkInputString();
            workers.add(new Worker(code, name, age, salary, workLocation));
            histories.add(new History("Initiate", name, code, name, age, salary, workLocation));
            return;
        }
    }

    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(Calendar.getInstance().getTime());
    }

    public Worker getWorkerById(ArrayList<Worker> workers) {
        System.out.print("Enter code: ");
        while (true) {
            String code = val.checkInputString();
            int index = val.isIdExists(workers, code);
            if (index == -1) {
                System.err.println("Code does not exist");
                System.out.print("Try again:");
            } else {
                return workers.get(index);
            }
        }
    }

    public void upSalary(ArrayList<Worker> workers, ArrayList<History> histories) {
        if (workers.isEmpty()) {
            System.err.println("List of workers is empty.");
            return;
        }
        System.out.println("=====================Up Salary===================");
        Worker w = getWorkerById(workers);
        double upSalary = val.checkDouble("Enter salary: ", 0, Double.POSITIVE_INFINITY);
        //set new salary 
        w.setSalary(w.getSalary() + upSalary);
        histories.add(new History("UP", getCurrentDate(), w.getId(), w.getName(), w.getAge(), w.getSalary(), w.getWorkLocation()));
    }

    public void downSalary(ArrayList<Worker> workers, ArrayList<History> histories) {
        if (workers.isEmpty()) {
            System.err.println("List of workers is empty.");
            return;
        }
        System.out.println("=====================Down Salary===================");
        Worker w = getWorkerById(workers);
        double downSalary = val.checkDouble("Enter salary: ", 0, w.getSalary());
        //set new salary 
        w.setSalary(w.getSalary() - downSalary);
        histories.add(new History("DOWN", getCurrentDate(), w.getId(), w.getName(), w.getAge(), w.getSalary(), w.getWorkLocation()));
    }

    public void displaySalaryInformation(ArrayList<History> histories) {
        if (histories.isEmpty()) {
            System.err.println("list is empty.");
            return;
        }
        System.out.println("============Display Salary Information===========");
        System.out.format("%10s%20s%10s%15s%10s%20s\n",
                "Code", "Name", "Age", "Salary", "Status", "Date");
        Collections.sort(histories);
        for (History history : histories) {
            System.out.format("%10s%20s%10s%15s%10s%20s\n",
                    history.getId(), history.getName(), history.getAge(), history.getSalary(), history.getStatus(), history.getDate());
        }
    }
}
