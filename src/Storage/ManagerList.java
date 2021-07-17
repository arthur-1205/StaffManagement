/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import DTO.Manager;
import DTO.Staff;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.MyToys;

/**
 *
 * @author Y545
 */
public class ManagerList {

    List<Manager> managerList = new ArrayList<>();
    public void addAManager() {
        Manager m;
        int id;
        String name, gender;
        int basicSalary, bonusSalary;
        int pos;
        do {
            id = MyToys.getAnInteger("Input Manager ID: ", "Staff ID must be a positive integer!!", 0, 10000000);
            pos = findAManager(id);
            if (pos >= 0) {
                System.out.println("Manager ID already exist!!Please input again!");
            }
        } while (pos != -1);

        name = MyToys.getAString("Input Manager name: ", "Manager name is required!");
        gender = MyToys.getMaleOrFemale("Input Manager gender: ", "Please input male or female!");
        basicSalary = MyToys.getAnInteger("Input basic salary of manager: ", "Please input a positive integer !!",
                0, 1000000000);
        bonusSalary = MyToys.getAnInteger("Input bonus salary of manager: ", "Please input a positive integer !!",
                0, 1000000000);
        managerList.add(new Manager(id, name, gender, basicSalary, bonusSalary, null, null));
        System.out.println("Add Manager succesfully");
    }

    public void updateManager() {
        Manager m;
        int pos;
        if (managerList.isEmpty()) {
            System.out.println("Manager List is empty!!");
            return;
        }
        do {
            int id = MyToys.getAnInteger("Input Manager ID to update: ", "Input a possitive integer!", 0, 10000000);
            pos = findAManager(id);
            m = searchAManager(id);
            if (pos == -1) {
                System.out.println("Manager not exist!! Please input again!");
            }
        } while (pos == -1);
        m.setName(MyToys.getAString("Input new Manager name: ", "Manager name is required!"));
        m.setGender(MyToys.getMaleOrFemale("Input new Manager gender: ", "Please input male or female!"));
        m.setBasicSalary(MyToys.getAnInteger("Input new basic salary of manager: ", "Please input a positive integer !!", 0, 1000000000));
        m.setBonusSalary(MyToys.getAnInteger("Input new bonus salary of manager: ", "Please input a positive integer !!",
                0, 1000000000));
        System.out.println("Update Manager successfully!");
        m.outputManager();
    }


    public boolean removeManager(int id) {
        if (managerList.isEmpty()) {
            System.out.println("Manager List is empty!!");
            return false;
        }
            Manager m = searchAManager(id);
            return managerList.remove(m);
    }

    public int findAManager(int id) {
        for (int i = 0; i < managerList.size(); i++) {
            if(managerList.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    public Manager searchAManager(int id) {
        for (Manager m : managerList) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public void sortManagerListByAscd() {
        Collections.sort(managerList);
    }
    
    public void displayAllManager() {
        if (managerList.isEmpty()) {
            System.out.println("Manager List is empty!!");
            return;
        }
        for (Manager manager : managerList) {
            manager.outputManager();
        }
    }
    
    public boolean isEmpty() {
        if(managerList.isEmpty())
            return true;
        return false;
    }

}
