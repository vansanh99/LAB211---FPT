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
public class Managing {

    public Validation val = new Validation();

    public int welcome() {
        System.out.println("===================Task Program==================");
        System.out.println("1. Add task\n"
                + "2. Delete task\n"
                + "3. Display task\n"
                + "4. Exit");
        int option = val.checkInt("Enter your choice: ", 1, 4);
        return option;
    }

    public void addTask(ArrayList<Task> tasks) {
        int id;
        if (tasks.isEmpty()) {
            id = 1;
        } else {
            id = tasks.get(tasks.size() - 1).getId() + 1;
        }
        System.out.println("=====================Add Task====================");
        System.out.print("Requirement Name: ");
        String requirementName = val.checkInputString();
        int taskType = val.checkInt("Task Type: ", 1, 4);
        System.out.print("Date: ");
        String date = val.checkDate("dd-MM-yyyy", "dd-MM-yyyy");
        double planFrom = 0;
        double planTo = 0;
        do {
            planFrom = val.checkTime("From: ");
            planTo = val.checkTime("To: ");
            
            if (planFrom > planTo) {
                System.err.println("Plan From must be less than Plan To. try again.");
            } else {
                break;
            }
        } while (planFrom > planTo);
        System.out.print("Assignee: ");
        String assignee = val.checkInputString();
        System.out.print("Reviewer: ");
        String reviewer = val.checkInputString();
        tasks.add(new Task(id, taskType, requirementName, date, planFrom, planTo, assignee, reviewer));
    }

    public void deleteTask(ArrayList<Task> tasks) {
        System.out.println("==================Delete task====================");
        while (true) {
            int id = val.checkInt("ID: ", 1, Integer.MAX_VALUE);
            int index = val.isIdExists(tasks, id);
            if (index != -1) {
                tasks.remove(index);
                System.out.println("remove successfully.");
                return;
            } else {
                System.err.println("Id not found. try again.");
            }
        }
    }

    public void getDataTasks(ArrayList<Task> tasks) {
        System.out.println("====================Task=========================");
        System.out.format("%-5s%-15s%-15s%-15s%-10s%-10s%-10s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        String typeName = "";
        double time = 0;
        for (Task task : tasks) {
            
            switch (task.getTaskTypeId()) {
                case 1: {
                    typeName = "Code";
                    break;
                }
                case 2: {
                    typeName = "Test";
                    break;
                }
                case 3: {
                    typeName = "Design";
                    break;
                }
                case 4: {
                    typeName = "Review";
                    break;
                }
            }
            time = task.getPlanTo() - task.getPlanFrom();
            System.out.format("%-5s%-15s%-15s%-15s%-10.1f%-10s%-10s\n",
                    task.getId(), task.getRequirementName(), typeName, task.getDate(), 
                    time, task.getAssignee(), task.getReviewer());
        }
    }
}
