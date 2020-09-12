/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workermanagement;

import entities.History;
import entities.Worker;
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
        ArrayList<Worker> workers = new ArrayList<>();
        ArrayList<History> histories = new ArrayList<>();
        while (true) {
            int option = m.welcome();
            switch (option) {
                case 1: {
                    m.addWorker(workers, histories);
                    break;
                }
                case 2: {
                    m.upSalary(workers, histories);
                    break;
                }
                case 3: {
                    m.downSalary(workers, histories);
                    break;
                }
                case 4: {
                    m.displaySalaryInformation(histories);
                    break;
                }
                case 5: {
                    return;
                }
            }
        }
    }

}
