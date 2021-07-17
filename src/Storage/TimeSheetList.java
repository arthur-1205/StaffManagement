
package Storage;

import DTO.TimeSheet;
import java.util.ArrayList;
import java.util.List;


public class TimeSheetList {
    List<TimeSheet> timeSheetList = new ArrayList<>();

    public void addTimeSheet(TimeSheet ts) {
        timeSheetList.add(ts);
        System.out.println("Add succesfully");
    }
    
    public void removeTimeSheet(TimeSheet ts) {
        timeSheetList.remove(ts);
        System.out.println("Remove successfully");
    }
    

    public TimeSheet searchTimeSheet(int staffId) {
        for (int i = 0; i < timeSheetList.size(); i++) {
            if (timeSheetList.get(i).getStaff().getId() == staffId)
                return timeSheetList.get(i);
        }
        return null;
    }
    
    public void checkTask(int id) {
        for (TimeSheet ts : timeSheetList) {
            if(ts.checkUseOfTask(id))
                timeSheetList.remove(ts);
        }
    }
    
    public Boolean checkDuplicateTaskOfTask(int staffId, int taskId) {
        for (int i = 0; i < timeSheetList.size(); i++) 
            if (timeSheetList.get(i).getStaff().getId() == staffId)
                if (timeSheetList.get(i).getTask().getId()== taskId)
                return true;
        return false;
    }
    
    public long getTotalWorkingHour(int staffId) {
        long sum = 0;
        TimeSheet timeSheet = searchTimeSheet(staffId);
        if(timeSheet == null)
            return 0;
        else 
            for (TimeSheet ts : timeSheetList) {
                if(ts.getStaff().getId() == staffId)
                    sum += ts.getWorkingHour();
            }
        return sum;
    }
    
    
    public void displayAllTotalTime() {
        List<Integer> tmp = new ArrayList();
        for (int i = 0; i < timeSheetList.size(); i++) {
            int count = 0;
            for (int j = 0; j < tmp.size(); j++) 
                if(tmp.get(j) == timeSheetList.get(i).getStaff().getId())
                    count++;
            if(count > 0)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
                continue;
            else{
            System.out.printf("|STAFF ID: %6d|STAFF NAME: %10s|TOTAL WORKING HOUR: %6d|\n",
                            timeSheetList.get(i).getStaff().getId(),  timeSheetList.get(i).getStaff().getName(),
                            getTotalWorkingHour(timeSheetList.get(i).getStaff().getId()));
            tmp.add(timeSheetList.get(i).getStaff().getId());
        }
            
    }
    }
   
    
        public void displayAllTimeSheet() { 
        if(timeSheetList.isEmpty())
            System.out.println("TimeSheet List is empty! Nothing to show!1");
        else{
            for (TimeSheet timeSheet : timeSheetList) {
                timeSheet.output();
            }
        }
           
    }
        
         public void checkStaffWTask(int taskId) {
        for (int i = 0; i < timeSheetList.size(); i++) {
                if(timeSheetList.get(i).getTask().getId() == taskId)
                    timeSheetList.get(i).setTask(null);
                       
        }
    }
    
         public void updateTimeSheet(TimeSheet ts, int idTaskN) {
        for (int i = 0; i < timeSheetList.size(); i++)
            if (timeSheetList.get(i).getStaff().getId() == ts.getStaff().getId() && timeSheetList.get(i).getTask().getId() == idTaskN) {
                timeSheetList.get(i).setTask(ts.getTask());
                break;
            }
    }
    public boolean isEmpty() {
        if(timeSheetList.isEmpty())
            return true;
        return false;
    }
    
    
}
