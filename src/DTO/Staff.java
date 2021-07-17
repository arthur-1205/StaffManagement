
package DTO;

import util.MyToys;

public class Staff implements Comparable<Staff>{
    protected int id;
    protected String name;
    protected String gender;
    protected int basicSalary;
    protected Manager manager;
    protected Task task;
    private String idManager;
    private String idTask;
    private String nameManager;

    public Staff() {
        id = 0;
        name = "";
        gender = "female";
        basicSalary = 0;
        manager = null;
    }

    public Staff(int id, String name, String gender, int basicSalary, Manager manager, Task task) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.basicSalary = basicSalary;
        this.manager = manager;
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
    
    
    
    public String getIdManager() {
        if(this.manager == null)
            idManager = null;
        else
            idManager = String.valueOf(this.manager.getId());
        return idManager;
    }
    
    public String getNameManager() {
        if(this.manager == null)
            nameManager = null;
        else
            nameManager = String.valueOf(this.manager.getName());
        return nameManager;
    }
    
 

    public void outputStaff() {
        System.out.printf("|STAFF   |ID: %4d|NAME: %15s|GENDER: %7s|BASIC SALARY: %12d|  MANAGER ID: %4s|  MANAGER NAME: %10s|\n", 
                            id, name, gender, basicSalary, getIdManager(), getNameManager());
    }
    
    public void ouputStaffWTask() {
        System.out.printf("|STAFF   |ID: %4d|NAME: %15s|MANAGER ID: %4s|MANAGER NAME: %10s| <<<<= ", 
                            id, name, getIdManager(), getNameManager());
    }

    @Override
    public int compareTo(Staff s) {
        if(id > s.getId()) return 1;
        else if(id < s.getId()) return -1;
        else return 0;  
    }
}
