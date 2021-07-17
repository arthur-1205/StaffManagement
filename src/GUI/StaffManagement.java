/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Manager;
import DTO.Staff;
import DTO.Task;
import DTO.TimeSheet;
import Storage.ManagerList;
import Storage.StaffList;
import Storage.TaskList;
import Storage.TimeSheetList;
import util.MyToys;

/**
 *
 * @author Y545
 */
public class StaffManagement {

    public static void main(String[] args) {
        ManagerList managerList = new ManagerList();
        StaffList staffList = new StaffList();
        TaskList taskList = new TaskList();
        TimeSheetList tsList = new TimeSheetList();

        Manager m;
        Task t;
        Staff s;

        int choice = 0;
        do {
            System.out.println("\n=============Staff Management Menu===============");
            System.out.println("1. Manage Staff list");
            System.out.println("2. Manage Manager list");
            System.out.println("3. Manage Task list");
            System.out.println("4. Establishing relations of Staff and Manager");
            System.out.println("5. Record working hour of staff");
            System.out.println("6. Exit the program!");

            choice = MyToys.getAnInteger("Input your choice: ", "Please input number from 1 to 6!!", 0, 6);
            switch (choice) {
                case 1:
                    int choice1 = 0;
                    do {
                        System.out.println("\n=======Manage Staff List========");
                        System.out.println("1. Add new Staff");
                        System.out.println("2. Update Staff");
                        System.out.println("3. Remove Staff");
                        System.out.println("4. Display all Staffs");
                        System.out.println("5. Exit");
                        choice1 = MyToys.getAnInteger("Input choice1: ", "Please input number from 1 to 5!!", 0, 5);
                        switch (choice1) {
                            case 1:
                                staffList.addAStaff();
                                break;
                            case 2:
                                staffList.updateStaff();
                                break;
                            case 3:
                                staffList.removeAStaff();
                                break;
                            case 4:
                                System.out.println("Information of all Staffs: ");
                                staffList.sortStaffListByAscd();
                                staffList.displayAllStaff();
                                break;
                        }

                    } while (choice1 != 5);

                    break;

//===========================Manage manager list===============================                    
                case 2:
                    int choice2 = 0;
                    do {
                        System.out.println("\n=========Manage Manager List========");
                        System.out.println("1. Add new Manager");
                        System.out.println("2. Update Manager");
                        System.out.println("3. Remove Manager");
                        System.out.println("4. Display all Managers");
                        System.out.println("5. Exit!");
                        choice2 = MyToys.getAnInteger("Input choice2: ", "Please input number from 1 to 5!!", 0, 5);
                        switch (choice2) {
                            case 1:
                                managerList.addAManager();
                                break;
                            case 2:
                                managerList.updateManager();
                                break;
                            case 3:
                                if (managerList.isEmpty()) {
                                    System.out.println("Manager List is empty!!");
                                    return;
                                } else {
                                    int id = MyToys.getAnInteger("Input Manager ID to remove: ", "Input a possitive integer!", 0, 10000000);
                                    m = managerList.searchAManager(id);
                                    if (m == null) {
                                        System.out.println("Manager not exist!!");
                                        return;
                                    } else {
                                        managerList.removeManager(id);
                                        staffList.checkStaffWManager(id);
                                    }
                                    System.out.println("=>>>>> Remove Manager successfully <<<<<=");
                                }
                                break;
                            case 4:
                                managerList.sortManagerListByAscd();
                                managerList.displayAllManager();
                                break;
                        }

                    } while (choice2 != 5);
                    break;

//===================Manage Task List======================                
                case 3:
                    int choice3 = 0;
                    do {
                        System.out.println("\n============Manage Task list============");
                        System.out.println("1. Add new Task");
                        System.out.println("2. Update Task");
                        System.out.println("3. Remove Task");
                        System.out.println("4. Display all Tasks");
                        System.out.println("5. Exit!!");
                        choice3 = MyToys.getAnInteger("Input choice3: ", "Please input number from 1 to 5!!", 0, 5);

                        switch (choice3) {
                            case 1:
                                taskList.addATask();
                                break;
                            case 2:
                                taskList.updateTask();
                                break;
                            case 3:
                                if (taskList.isEmpty()) {
                                    System.out.println("Task list is empty!!");
                                    return;
                                }
                                int id = MyToys.getAnInteger("Input Task ID to remove: ", "Task ID must be a positive integer!!", 0);
                                t = taskList.searchTask(id);
                                if (t == null) {
                                    System.out.println("Task ID is not exist!!");
                                    break;
                                } else {
                                    taskList.removeTask(id);
                                    tsList.checkStaffWTask(id);
                                    System.out.println("Remove successfully!");
                                }
                                break;
                            case 4:
                                taskList.sortTaskListByAcsd();
                                taskList.displayAllTasks();
                                break;
                        }
                    } while (choice3 != 5);
                    break;

//========================Establishing relations of Staff and Manager============================
                case 4:
                    int choice4 = 0;
                    do {
                        System.out.println("\n========Establishing relations of Staff and Manager========");
                        System.out.println("1. Set relationship of Staff and Manager");
                        System.out.println("2. Remove Relationship");
                        System.out.println("3. Display all Relationship");
                        System.out.println("4. Exit!");
                        choice4 = MyToys.getAnInteger("Input choice4: ", "Please input number from 1 to 5!!", 0, 4);
                        switch (choice4) {
                            case 1:
                                int pos;
                                int idStaff = 0,
                                 idManager = 0;

                                if (staffList.isEmpty()) {
                                    System.out.println("Staff List is empty!!");
                                    break;
                                } else if (managerList.isEmpty()) {
                                    System.out.println(" Manager List is empty!!");
                                    break;
                                } else {
                                    do {
                                        idStaff = MyToys.getAnInteger("Input Staff ID to set relationship: ",
                                                "Staff ID must be a positive integer!!", 0, 10000000);
                                        pos = staffList.findAStaff(idStaff);
                                        if (pos == -1) {
                                            System.out.println("Not found Staff ID! Please input again!");
                                            break;
                                        }
                                        idManager = MyToys.getAnInteger("Input Manager ID to set relationship: ",
                                                "Manager ID must be a positive integer!!", 0, 10000000);
                                        pos = managerList.findAManager(idManager);
                                        if (pos == -1) {
                                            System.out.println("Not found Manager ID. Please input again!");
                                            break;
                                        }
                                        staffList.searchAStaff(idStaff).setManager(managerList.searchAManager(idManager));
                                        System.out.println("=>>>> Set relationship successfully!! <<<<=");
                                    } while (pos == -1);
                                }
                                break;

                            case 2:
                                if (staffList.isEmpty()) {
                                    System.out.println("Staff List is empty!1");
                                    break;
                                } else if (managerList.isEmpty()) {
                                    System.out.println(" Manager List is empty!!");
                                    break;
                                } else {
                                    do {
                                        idStaff = MyToys.getAnInteger("Input Staff ID to remove relationship: ",
                                                "Staff ID must be a positive integer!!", 0, 10000000);
                                        s = staffList.searchAStaff(idStaff);
                                        if (s == null) {
                                            System.out.println("Not found Staff ID! Please input again!");
                                            break;
                                        }

                                    } while (s == null);
                                    s.setManager(null);
                                    System.out.println("Remove relationship successfully!!");
                                }
                                break;

                            case 3:
                                System.out.println("All relationship between Staff - Manager: ");
                                staffList.sortStaffListByAscd();
                                staffList.displayAllStaff();
                                break;
                        }
                    } while (choice4 != 4);
                    break;

//===================Record working hour=========================
                case 5:
                    int choice5 = 0;
                    do {
                        System.out.println("========Recording menu=======");
                        System.out.println("1. Record working hour of staff");
                        System.out.println("2. Update Task of Staff: ");
                        System.out.println("3. Remove record");
                        System.out.println("4. Display all Task of all Staff");
                        System.out.println("5. Display Total working hour of Staff");
                        System.out.println("6. Exit!!");
                        choice5 = MyToys.getAnInteger("Input choice5: ", "Please input number from 1 to 6!!", 0, 6);
                        switch (choice5) {
                            case 1:
                                int idStaff,
                                 idTask;
                                if (staffList.isEmpty()) {
                                    System.out.println("Staff List is empty!1");
                                    break;
                                } else if (taskList.isEmpty()) {
                                    System.out.println("Task List is empty!! Working hour not added yet!!");
                                    break;
                                } else {
                                    idStaff = MyToys.getAnInteger("Input Staff ID to record: ",
                                            "Staff ID must be a positive integer!!", 0);
                                    s = staffList.searchAStaff(idStaff);
                                    if (s == null) {
                                        System.out.println("Not found Staff ID! Please input again!");
                                        break;
                                    }
                                    idTask = MyToys.getAnInteger("Input Task ID to record: ", "Task ID must be a positive integer", 0);
                                    t = taskList.searchTask(idTask);
                                    if (t == null) {
                                        System.out.println("Not found Task ID! Please input again!");
                                        break;
                                    }
                                    if (tsList.checkDuplicateTaskOfTask(idStaff, idTask)) {
                                        System.out.println("Staff " + s.getName() + " has do this work!! Please input again!");
                                        break;
                                    }
                                    s.setTask(t);
                                    tsList.addTimeSheet(new TimeSheet(s, t, t.getTotalHour()));
                                    System.out.println("Recorded successfully!");
                                }
                                break;

                            case 2:
                                if (staffList.isEmpty()) {
                                    System.out.println("Staff List is empty!1");
                                    break;
                                } else if (taskList.isEmpty()) {
                                    System.out.println("Task List is empty!! Working hour not added yet!!");
                                    break;
                                }
                                idStaff = MyToys.getAnInteger("Input Staff Id you want to change Task: ",
                                        "Staff Id must be a positive integer!", 0);
                                s = staffList.searchAStaff(idStaff);
                                if (s == null) {
                                    System.out.println("Not found Staff!!");
                                    break;
                                }

                                if (tsList.searchTimeSheet(idStaff) == null) {
                                    System.out.println("Staff does not have any task!!");
                                    break;
                                } else {
                                    idTask = MyToys.getAnInteger("Input Task Id you want to change: ",
                                            "Task Id must be a positive integer!!", 0);
                                    t = taskList.searchTask(idTask);
                                    if (t == null) {
                                        System.out.println("Task Id does not exist!!");
                                        break;
                                    }
                                    int idTaskN = MyToys.getAnInteger("Input Task Id you want to replace: ",
                                            "Task Id must be a positive integer!!", 0);
                                    Task tn = taskList.searchTask(idTaskN);
                                    if (tn == null) {
                                        System.out.println("This Task does not exist!!");
                                        break;
                                    } else {
                                        tsList.updateTimeSheet(new TimeSheet(s, tn, tn.getTotalHour()), idTask);
                                        System.out.println("Update Task of Staff successfully!!");
                                    }
                                }
                                break;
                            case 3:
                                if (staffList.isEmpty()) {
                                    System.out.println("Staff List is empty!1");
                                    break;
                                } else if (taskList.isEmpty()) {
                                    System.out.println("Task List is empty!! Working hour not added yet!!");
                                    break;
                                } else {
                                    idStaff = MyToys.getAnInteger("Input Staff ID to remove record: ",
                                            "Staff ID must be a positive integer!!", 0);
                                    s = staffList.searchAStaff(idStaff);
                                    if (s == null) {
                                        System.out.println("Not found Staff ID! Please input again!");
                                        break;
                                    }
                                    s.setTask(null);
                                    System.out.println("=>>>> Remove record successfully!! <<<<=");
                                }
                                break;

                            case 4:
                                if (tsList.isEmpty()) {
                                    System.out.println("Nothing to show!!");
                                    break;
                                }
                                System.out.println("Information of relationship between Staff and Task: ");
                                tsList.displayAllTimeSheet();
                                break;

                            case 5:
                                if (tsList.isEmpty()) {
                                    System.out.println("Nothing to show!!");
                                    break;
                                }
                                System.out.println("Total Working Hour of all Staffs: ");
                                tsList.displayAllTotalTime();
                                break;

                            case 6:
                                System.out.println("Thanks for using!!");
                                break;
                        }
                    } while (choice5 != 6);
            }
        } while (choice != 6);
    }
}
