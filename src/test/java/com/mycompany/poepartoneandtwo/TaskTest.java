
package com.mycompany.poepartoneandtwo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TaskTest {
    
    public TaskTest() {
    }

    

    /**
     * Test of checkDescription method, of class Task.
     */
    @org.junit.jupiter.api.Test
    public void testCheckDescriptionTest1() {
        System.out.println("checkDescription");
       String description ="Create Login to authenticate users";
        Task instance = new Task();
        boolean expResult = true;
        boolean result = instance.checkDescription(description);
        assertEquals(expResult, result);
        
    }
    @org.junit.jupiter.api.Test
    public void testCheckDescriptionTest2() {
        System.out.println("checkDescription");
       String description ="Create Add Task feature to add task users";
        Task instance = new Task();
        boolean expResult = true;
        boolean result = instance.checkDescription(description);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of CreateTaskID method, of class Task.
     */
    @org.junit.jupiter.api.Test
    public void testCreateTaskIDTest1() {
        System.out.println("CreateTaskID");
        String taskname = "Login Feature";
        int tasknumber = 0;
        String Developerdetails = "Robyn Harrison";
       
        String expResult = "LO:0:SON";
        Task instance = new Task();
        
        String result = instance.CreateTaskID(taskname, tasknumber, Developerdetails);
        assertEquals(expResult, result);
        
    }
     @org.junit.jupiter.api.Test
    public void testCreateTaskIDTest2() {
        System.out.println("CreateTaskID");
         String taskname = "Add Task Feature";
        int tasknumber = 1;
        String Developerdetails = "Mike Smith";
       
        String expResult = "AD:1:ITH";
        Task instance = new Task();
        
        String result = instance.CreateTaskID(taskname, tasknumber, Developerdetails);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of printTaskDetails method, of class Task.
     */
    @org.junit.jupiter.api.Test
    public void testPrintTaskDetails1() {
        System.out.println("printTaskDetails");
        String taskdetails = "To Do";
        String developerDetails = "Robyn Harrison";
        int tasknumber = 0;
        String taskname= "Login Feature";
        String taskdiscript = "Create Login to authenticate users";
        String taskid = "";
        int taskduration = 8;
        Task instance = new Task();
        String expResult = taskdetails+ developerDetails + tasknumber +taskname+taskdiscript + taskid +taskduration;
        String result = instance.printTaskDetails(taskdetails, developerDetails, tasknumber, taskname, taskdiscript, taskid, taskduration);
        assertEquals(expResult, result);
        
    }
    @org.junit.jupiter.api.Test
    public void testPrintTaskDetails2() {
        System.out.println("printTaskDetails");
        String taskdetails =  "Doing";
        String developerDetails = "Mike Smith";
        int tasknumber = 1;
        String taskname= "Add Task Feature";
        String taskdiscript = "Create Add Task feature to add task users";
        String taskid = "";
        int taskduration = 10;
        Task instance = new Task();
        String expResult = taskdetails+ developerDetails + tasknumber +taskname+taskdiscript + taskid +taskduration;
        String result = instance.printTaskDetails(taskdetails, developerDetails, tasknumber, taskname, taskdiscript, taskid, taskduration);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of returnHours method, of class Task.
     */
    @org.junit.jupiter.api.Test
    public void testReturnHours() {
        System.out.println("returnHours");
        int hours = 8;
        Task instance = new Task();
        int expResult = 8;
        int result = instance.returnHours(hours);
        assertEquals(expResult, result);
        
    }
    
}
