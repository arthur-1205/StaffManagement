/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author Y545
 */
public class Manager extends Staff{
        int bonusSalary;

    public Manager() {
        super();
        bonusSalary = 0;
    }
    
    public Manager(int id, String name, String gender, int basicsalary, int bonusSalary, Manager manager, Task task){
        super(id, name, gender, basicsalary, manager, task);
        this.bonusSalary = bonusSalary;
    }

    public long getBonusSalary() {
        return bonusSalary;
    }

    public void setBonusSalary(int bonusSalary) {
        this.bonusSalary = bonusSalary;
    }
    

    public void outputManager() {
        System.out.printf("|MANAGER |ID: %4d|NAME: %10s|GENDER: %6s|BASIC SALARY: %12d|BONUS: %12d|\n", 
                                id, name ,gender, basicSalary, bonusSalary);
    }
}
