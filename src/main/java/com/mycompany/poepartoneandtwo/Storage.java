/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepartoneandtwo;
import javax.swing.JOptionPane;



public class Storage {
    public void DisplayTaskReport(String[] statusOptions, String[] developerDetails, String[] taskName, String[] taskDescription, String[] taskID, int[] time) {
    StringBuilder report = new StringBuilder(); // Use StringBuilder to accumulate task information
    for (int i = 0; i < taskName.length; i++) {
        // Check if the taskName is not null or empty and status is not null
        if (taskName[i] != null && !taskName[i].trim().isEmpty() && statusOptions[i] != null) {
            report.append("Task ID: ").append(taskID[i]).append("\n")
                  .append("Task Name: ").append(taskName[i]).append("\n")
                  .append("Task Number: ").append(i).append("\n")
                  .append("Developer: ").append(developerDetails[i]).append("\n")
                  .append("Description: ").append(taskDescription[i]).append("\n")
                  .append("Status: ").append(statusOptions[i]).append("\n")
                  .append("Duration: ").append(time[i]).append(" hours\n")
                  .append("-------------------------------\n");
        }
    }

    // If report has content, display it; otherwise, show a message indicating no valid tasks.
    if (report.length() > 0) {
        JOptionPane.showMessageDialog(null, report.toString(), "Task Report", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "No valid tasks to display.", "Task Report", JOptionPane.INFORMATION_MESSAGE);
    }
}


    // Method to display completed tasks
    public void DisplayCompletedTasks(String[] statusOptions, String[] developerDetails, String[] taskName, int[] time) {
    StringBuilder completedTasks = new StringBuilder(); // StringBuilder to accumulate completed task details
    for (int i = 0; i < statusOptions.length; i++) {
        // Check if statusOptions[i] is not null and equals "Done"
        if (statusOptions[i] != null && statusOptions[i].equalsIgnoreCase("Done")) {
            completedTasks.append("Task ID: ").append(taskName[i]).append("\n")
                    .append("Developer: ").append(developerDetails[i]).append("\n")
                    .append("Task Name: ").append(taskName[i]).append("\n")
                    .append("Duration: ").append(time[i]).append(" hours\n")
                    .append("----------------------------\n");
        }
    }

    if (completedTasks.length() == 0) {
        JOptionPane.showMessageDialog(null, "No completed tasks found.", "Completed Tasks", JOptionPane.INFORMATION_MESSAGE);
    } else {
        // Display the completed tasks
        JOptionPane.showMessageDialog(null, completedTasks.toString(), "Completed Tasks", JOptionPane.INFORMATION_MESSAGE);
    }
}


    // Method to display task with the longest duration
    public void DisplayTaskwithLongestDuration(int[] time, String[] developerDetails, String[] taskName) {
        int longestDurationIndex = 0;
        for (int i = 1; i < time.length; i++) {
            if (time[i] > time[longestDurationIndex]) {
                longestDurationIndex = i;
            }
        }

        // Using StringBuilder to show the task with the longest duration
        StringBuilder longestTaskDetails = new StringBuilder();
        longestTaskDetails.append("Task with longest duration:\n")
                .append("Task Name: ").append(taskName[longestDurationIndex]).append("\n")
                .append("Developer: ").append(developerDetails[longestDurationIndex]).append("\n")
                .append("Duration: ").append(time[longestDurationIndex]).append(" hours\n");

        JOptionPane.showMessageDialog(null, longestTaskDetails.toString(), "Longest Task", JOptionPane.INFORMATION_MESSAGE);
    }

    // Task search by name
    public void SearchTaskbyTaskName(String[] taskName, String [] status,String[] developerDetails, String search) {
        StringBuilder searchResult = new StringBuilder();
        boolean found = false;
        
        for (int i = 0; i < taskName.length; i++) {
            if (taskName[i].equalsIgnoreCase(search)) {
                searchResult.append("Task found:\n")
                        .append("Task Name: ").append(taskName[i]).append("\n")
                        .append("Developer Details: ").append(developerDetails[i]).append("\n")
                        .append("Task Status: ").append(status[i]).append("\n");
                found = true;
                break;
            }
        }

        if (found) {
            JOptionPane.showMessageDialog(null, searchResult.toString(), "Search Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Task not found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Task search by developer
    public void SearchTaskByDeveloperdetails(String[] developerDetails, String [] Status,String[] taskName, String search) {
        StringBuilder developerSearchResult = new StringBuilder();
        boolean found = false;
        
        for (int i = 0; i < developerDetails.length; i++) {
            if (developerDetails[i].equalsIgnoreCase(search)) {
                developerSearchResult.append("Developer: ").append(developerDetails[i]).append("\n")
                        .append("Task Name: ").append(taskName[i]).append("\n")
                        .append("Task Satus: ").append(Status[i]).append("\n");
                found = true;
                break;
            }
        }

        if (found) {
            JOptionPane.showMessageDialog(null, developerSearchResult.toString(), "Developer Search Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Developer not found.", "Developer Search Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Method to delete tasks
    public void deleteTasks(String[] taskName, int[] time, String[] taskID, String[] developerDetails, String deleteTask, String[] taskDescription) {
        StringBuilder deleteTaskResult = new StringBuilder();
        boolean taskFound = false;
        
        for (int i = 0; i < taskName.length; i++) {
            if (taskName[i].equalsIgnoreCase(deleteTask)) {
                deleteTaskResult.append("Deleting task: ").append(taskName[i]).append("\n")
                        .append("Task ID: ").append(taskID[i]).append("\n")
                        .append("Developer: ").append(developerDetails[i]).append("\n");
                taskName[i] = null; // Remove task name
                time[i] = 0; // Set time to 0
                taskID[i] = null; // Remove Task ID
                developerDetails[i] = null; // Remove developer details
                taskDescription[i] = null; // Remove description
                taskFound = true;
                break;
            }
        }

        if (taskFound) {
            JOptionPane.showMessageDialog(null, deleteTaskResult.toString(), "Task Deletion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Task not found for deletion.", "Task Deletion", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
