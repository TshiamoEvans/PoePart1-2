
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