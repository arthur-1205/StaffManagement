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
public class Task implements Comparable<Task>{
    private int id;
    private String title;
    private String beginDate;
    private String endDate;
    private int totalHour;

    public Task(int id, String title, String beginDate, String endDate, int totalHour) {
        this.id = id;
        this.title = title;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.totalHour = totalHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(int totalHour) {
        this.totalHour = totalHour;
    }
    
    
    
    public void outputTask() {
        System.out.printf("|TASK  |ID: %4d|TITLE: %10s|BEGIN DATE: %13s|END DATE: %13s|TOTAL HOUR: %8d|\n",
                                    id, title, beginDate, endDate, totalHour);
    }
    
    public void outputTaskWStaff() {
         System.out.printf("|TASK  |ID: %4d|TITLE: %10s|BEGIN DATE: %13s|END DATE: %13s|TOTAL HOUR: %8d|\n",
                                    id, title, beginDate, endDate, totalHour);
    }

    @Override
    public int compareTo(Task o) {
        if(id > o.getId()) return 1;
        else if(id < o.getId()) return -1;
        else return 0;
    }          
}
