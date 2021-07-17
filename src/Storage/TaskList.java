/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import DTO.Task;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.MyToys;

/**
 *
 * @author Y545
 */
public class TaskList {

    List<Task> taskList = new ArrayList<>();

    public void addATask() {
        int id, pos;
        String title;
        String beginDate, endDate;
        int totalHour;
        do {
            id = MyToys.getAnInteger("Input Task ID: ", "Input a positive integer!!", 0);
            pos = findTask(id);
            if (pos >= 0) {
                System.out.println("Task ID already exist! Please input a new task id");
            }
        } while (pos != -1);
        title = MyToys.getAString("Input Task Title: ", "Title is required!!");
        beginDate = MyToys.getID("Input Begin Date: ", "Please follow format dd/MM/yyyy",
                "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
        endDate = MyToys.getID("Input End Date: ", "Please follow format dd/MM/yyyy",
                "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
        totalHour = MyToys.getAnInteger("Input Total Hours: ", "Input a positive integer!!", 1);
        taskList.add(new Task(id, title, beginDate, endDate, totalHour));
        System.out.println("Added successfully!!");
    }

    public void updateTask() {
        int pos;
        Task t;
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty!");
            return;
        }
        do {
            int id = MyToys.getAnInteger("Input Task ID to update: ", "Task ID must be an integer!!");
            pos = findTask(id);
            t = searchTask(id);
            if (pos == -1) {
                System.out.println("Task is not exist!!Please input again!");
            }
        } while (pos == -1);

        t.setTitle(MyToys.getAString("Input new Task Title: ", "Title is required!!"));
        t.setBeginDate(MyToys.getID("Input new Begin Date: ", "Please follow format dd/MM/yyyy",
                "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)"));
        t.setEndDate(MyToys.getID("Input new End Date: ", "Please follow format dd/MM/yyyy",
                "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)"));
        t.setTotalHour(MyToys.getAnInteger("Input new Total Hours: ", "Input a positive integer!!", 0));

        System.out.println("Update successfully!!");
        t.outputTask();
    }

    public void removeTask(int id) {
        Task t = searchTask(id);
        taskList.remove(t);
    }

    public int findTask(int id) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Task searchTask(int id) {
        for (Task t : taskList) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public void sortTaskListByAcsd() {
        Collections.sort(taskList);
    }

    public void displayAllTasks() {
        if (taskList.isEmpty()) {
            System.out.println("Task List is empty!! Nothing to show!!");
        }
        for (Task task : taskList) {
            task.outputTask();
        }
    }

    public boolean isEmpty() {
        if (taskList.isEmpty()) {
            return true;
        }
        return false;
    }
}
