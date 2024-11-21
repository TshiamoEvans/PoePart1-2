/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepartoneandtwo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;

public class StorageTest {

    private Storage storage;
    private String[] statusOptions;
    private String[] developerDetails;
    private String[] taskName;
    private String[] taskDescription;
    private String[] taskID;
    private int[] time;

    @BeforeEach
    public void setUp() {
        storage = new Storage();
        statusOptions = new String[]{"To Do", "Doing", "Done", "To Do"};
        developerDetails = new String[]{"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        taskName = new String[]{"Create Login", "Create Add Features", "Create Reports", "Add Arrays"};
        taskDescription = new String[]{"", "", "", ""}; // Assuming descriptions are empty for simplicity
        taskID = new String[]{"CR:0:ITH", "CR:1:SON", "CR:2:SON", "AD:3:ZER"};
        time = new int[]{5, 8, 2, 11};
    }

    @Test
    public void testDisplayTaskReport() {
      
        storage.DisplayTaskReport(statusOptions, developerDetails, taskName, taskDescription, taskID, time);
        
        
    }

    @Test
    public void testDisplayCompletedTasks() {
        storage.DisplayCompletedTasks(statusOptions, developerDetails, taskName, time);
        
       
    }

    @Test
    public void testDisplayTaskwithLongestDuration() {
        storage.DisplayTaskwithLongestDuration(time, developerDetails, taskName);

       
    }

    @Test
    public void testSearchTaskbyTaskName() {
        storage.SearchTaskbyTaskName(taskName, statusOptions, developerDetails, "Create Login");

      
    }

    @Test
    public void testSearchTaskByDeveloperdetails() {
        storage.SearchTaskByDeveloperdetails(developerDetails, statusOptions, taskName, "Samantha Paulson");

        
    }

    @Test
    public void testDeleteTasks() {
        storage.deleteTasks(taskName, time, taskID, developerDetails, "Create Reports", taskDescription);
        
        
        assertNull(taskName[2], "The task name should be null after deletion.");
        assertEquals(0, time[2], "The task duration should be 0 after deletion.");
        assertNull(taskID[2], "The task ID should be null after deletion.");
        assertNull(developerDetails[2], "The developer details should be null after deletion.");
        assertNull(taskDescription[2], "The task description should be null after deletion.");
    }
}
