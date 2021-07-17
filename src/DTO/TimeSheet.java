/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Y545
 */
public class TimeSheet {
    Staff staff;
    Task task;
    int workingHour;

    public TimeSheet(Staff staff, Task task, int totalHour) {
        this.staff = staff;
        this.task = task;
        this.workingHour = totalHour;
    }

    
    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(int workingHour) {
        this.workingHour = workingHour;
    }

    public TimeSheet(Staff staff, Task task) {
        this.staff = staff;
        this.task = task;
    }
    public boolean checkUseOfTask(int id) {
        if(task.getId() == id)
            return true;        
        return false;
    }
    
    public void output() {
        if(staff != null && task != null){
            System.out.printf("|STAFF ID:  %4d|STAFF NAME: %15s|TASK ID: %4d|TASK TITLE: %10s|WORKHOUR: %5d|\n",
                                    staff.getId(), staff.getName(), task.getId(), task.getTitle(), task.getTotalHour());
        }
    }
   
}
