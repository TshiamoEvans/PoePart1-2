
package com.mycompany.poepartoneandtwo;

import javax.swing.JOptionPane;

public class Task {
   public boolean checkDescription(String description){
    // declared and assigned a boolean datatype with the question that is less likely to be true 
       boolean check = false;
        
        // conditional statement that checks if the length of the descriptionexceeds 50
        if(description.length() < 50){
            
            JOptionPane.showMessageDialog(null, "task description is successfully captured");
            check = true;
        }
        else{
            JOptionPane.showMessageDialog(null, "task description should not be more than 50");
            
            check = false;
        }
        
        
        return check;
    }
    public String CreateTaskID(String taskname , int tasknumber , String Developerdetails){
        
        String taskid = taskname.substring(0,2) + ":" + tasknumber + ":" + Developerdetails.substring(Developerdetails.length()-3);
        
        
        return taskid.toUpperCase(); 
        
    }
   public String printTaskDetails(String taskdetails ,  String developerDetails,int tasknumber, String taskname ,String taskdiscript, String taskid, int taskduration  ){
         // Declared and assigned a variable which will cadd all the task details
         String values = "*****The task details are as follows***** \n" + "Tasksatus: " + taskdetails+ "\n"
                 + "Developer details: " + developerDetails + "\n"
                + "Task number: " + tasknumber + "\n" 
                 + "Task name: " + taskname + "\n"
                 + "Task description: " + taskdiscript + "\n" 
                 + "Task id:  " + taskid + "\n" +
                 "Task duration: " +taskduration + "hrs" + " \n <<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>> \n " ;
         
         // used JOption to display the task details
         JOptionPane.showMessageDialog(null,values);
         
         return "";
     }
     // created a method to calculate the total hours of all the tasks combined, passed on a parameter that is a integer
     public int returnHours(int hours){
         //declared and assigned a variable to the parameter
         int totalhours = hours;
     
     
     return totalhours;
     } 
      public String CHOOSETaskStatus() {
       //a value returning function  
         String[] choose ={"To do", "Done","Doing"};
        int t=JOptionPane.showOptionDialog(
                null, 
                "Please select a Status", "Status options", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choose, 0);
                  
        String task = choose[t];
        return task;
    }
}
