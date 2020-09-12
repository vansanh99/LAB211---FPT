/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagement;

import entities.Task;
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
        ArrayList<Task> tasks = new ArrayList<>();
        while(true) {
            int option = m.welcome();
            switch(option) {
                case 1: {
                    m.addTask(tasks);
                    break;
                }
                case 2: {
                    m.deleteTask(tasks);
                    break;
                }
                case 3: {
                    m.getDataTasks(tasks);
                    break;
                }
                case 4: {
                    return;
                }
            }
        }
    }
    
}
