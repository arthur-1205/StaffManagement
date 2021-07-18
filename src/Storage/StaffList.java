package Storage;

import DTO.Staff;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import util.MyToys;

public class StaffList {

    private List<Staff> staffList = new ArrayList<>();

    public void addAStaff() {
        int id;
        String name, gender;
        int basicSalary;
        int pos;
        System.out.println("Input Staff information: ");
        do {
            id = MyToys.getAnInteger("Input Staff ID: ", "Staff ID must be a positive integer!!", 0, 10000);
            pos = findAStaff(id);
            if (pos >= 0) {
                System.out.println("Staff ID already exist!!");
            }
        } while (pos != -1);
        name = MyToys.getAString("Input Staff name: ", "Staff name is required!");
        gender = MyToys.getMaleOrFemale("Input Staff gender: ", "Please input male or female!");
        basicSalary = MyToys.getAnInteger("Input basic salary of staff: ", "Please input a positive integer !!",
                0, 1000000000);
        staffList.add(new Staff(id, name, gender, basicSalary, null, null));
        System.out.println("===> Add Staff successfully!! <====");
    }

    public void updateStaff() {
        Staff s;
        int pos;
        if (staffList.isEmpty()) {
            System.out.println("Staff list is empty!!Please input Staff first!");
            return;
        }
        do { 
        int id = MyToys.getAnInteger("Input Staff ID to remove: ", "Staff ID must be a positive integer!!", 0, 10000000);
        s = searchAStaff(id);
        pos = findAStaff(id);
        if (pos == -1) 
            System.out.println("Not found Staff!! Please input again !!");
        } while (pos == -1);
            s.setName(MyToys.getAString("Input new Staff name: ", "Invalid format!!"));
            s.setGender(MyToys.getMaleOrFemale("Input new Staff gender: ", "Please input male or female!"));
            s.setBasicSalary(MyToys.getAnInteger("Input new basic salary of Staff: ", "Please input a positive integer!!",
                    0, 1000000000));
            System.out.println("Update succesfully!!");
            s.outputStaff();
        
    }

    public int findAStaff(int id) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Staff searchAStaff(int id) {
        for (Staff s : staffList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void removeAStaff() {
        if (staffList.isEmpty()) {
            System.out.println("Staff List is empty!!");
            return;
        }
        int id = MyToys.getAnInteger("Input Staff ID to remove: ", "Staff ID must be a positive integer!!", 0, 10000000);
        Staff s = searchAStaff(id);
        if (s == null) {
            System.out.println("Staff is not exist!!");
            return;
        } else {
            System.out.println("Remove Staff successfully!");
            staffList.remove(s);
        }
    }

    public void displayAllStaff() {
        if (staffList.isEmpty()) {
            System.out.println("Staff List is empty. Nothing to show!!");
            return;
        }
        for (Staff staff : staffList) {
            staff.outputStaff();
        }
    }

    public void checkStaffWManager(int managerId) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getManager() != null) {
                if (staffList.get(i).getManager().getId() == managerId) {
                    staffList.get(i).setManager(null);
                }
            }
        }
    }

    public void sortStaffListByAscd() {
        Collections.sort(staffList);
    }
    
    public void showAllTotalTime() {
 
    }

    public boolean isEmpty() {
        if (staffList.isEmpty()) {
            return true;
        }
        return false;
    }

}
