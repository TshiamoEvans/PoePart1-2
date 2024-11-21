

package com.mycompany.poepartoneandtwo;


import javax.swing.JDialog;


import javax.swing.JOptionPane;
import java.util.Scanner;

public class PoePartOneAndTwo {
    // Main method for Task Management (after login)
public static void main(String[] args) {
    //part 1
        final JDialog dial = new JDialog();
        dial.setAlwaysOnTop(true);
        LOGIN login = new LOGIN();
          Scanner console = new Scanner(System.in);
        System.out.println("Welcome, please enter the following details to register");
        System.out.print("Enter First Name: ");
        String firstName = console.nextLine();
        login.setFirstname(firstName);

        System.out.print("Enter Last Name: ");
        String lastName = console.nextLine();
        login.setLastname(lastName);

        String username;
        do {
            System.out.print("Enter Username: ");
            username = console.nextLine();
        } while (!login.checkUsername(username));

        String password;
        do {
            System.out.print("Enter Password: ");
            password = console.nextLine();
        } while (!login.checkPassword(password));

        String registrationStatus = login.registerUser(firstName, lastName, username, password);
        System.out.println("Registration:\n" + registrationStatus);

        System.out.println("*********** Login ***********");

        boolean loginIsSuccessful = false;
        do {
            System.out.print("Enter Username: ");
            String loginUsername = console.nextLine();

            System.out.print("Enter Password: ");
            String loginPassword = console.nextLine();

            loginIsSuccessful = login.loginUser(loginUsername, loginPassword);
            String displayMessage = login.returnLoginStatus(loginIsSuccessful);
            System.out.println(displayMessage);
        } while (!loginIsSuccessful); // Loop until successful login

        
    // ... part 2 starts here
    Storage store = new Storage();
    int option = 0;
    int sum = 0; 
    // Arrays to store task details
    //adjusting the arrays 
    String[] taskName = new String[10]; 
    String[] taskDescription = new String[10]; 
    String[] developerDetails = new String[10]; 
    int[] time = new int[10]; 
    String[] taskID = new String[10];
    String[] taskStatus = new String[10]; 
    
    Task task = new Task();
    JOptionPane.showMessageDialog(null, "Welcome to EasyKanBan: ");
    
    while (option != 3) {
        option = Integer.parseInt(JOptionPane.showInputDialog("Choose an option to proceed with: \n 1: Add tasks \n 2: Show report \n 3: Quit"));

        switch (option) {
            case 1:
                // Adding tasks
                int size = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to capture?"));
                 taskName = new String[size];
                    taskDescription = new String[size];
                    developerDetails = new String[size];
                    taskID = new String[size];
                    time = new int[size];
                    taskStatus = new String[size];
                // Initialize arrays with the size provided by the user
                for (int y = 0; y < size; y++) {
                    taskName[y] = JOptionPane.showInputDialog("Enter Task name:");
                    
                    do {
                        taskDescription[y] = JOptionPane.showInputDialog("Enter Task Description (characters should not exceed 50):");
                    } while (!task.checkDescription(taskDescription[y]));
                    
                    developerDetails[y] = JOptionPane.showInputDialog("Enter Developer Details (Firstname and Lastname):");
                    time[y] = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration:"));
                    
                    // Create Task ID
                    taskID[y] = task.CreateTaskID(taskName[y], y, developerDetails[y]);
                    JOptionPane.showMessageDialog(null, "Task ID: \n" + taskID[y]);

                    // Status selection
                    int statusMenu = Integer.parseInt(JOptionPane.showInputDialog("Choose a status: \n 1: To Do \n 2: Doing \n 3: Done"));
                    switch (statusMenu) {
                        case 1:
                            taskStatus[y] = "To Do";
                            break;
                        case 2:
                            taskStatus[y] = "Doing";
                            break;
                        case 3:
                            taskStatus[y] = "Done";
                            break;
                    }
                    
                    JOptionPane.showMessageDialog(null, "Status: \n" + taskStatus[y]);         

                    // Accumulate total hours
                    sum += task.returnHours(time[y]);
                }
                JOptionPane.showMessageDialog(null, "The total hours of all the tasks performed: " + sum + " hrs");
                break;
                
          //part 3 starts here
            case 2:
                // Task report options
                boolean exitCurrent=true;
                //while loop to loop the second menu 
                while(exitCurrent){
                int menuOption = Integer.parseInt(JOptionPane.showInputDialog("Choose an option: \n 1: Show report \n 2: View all completed tasks \n 3: Display task with longest duration \n 4: Search for task \n 5: Search tasks by developer \n 6: Delete a task \n 7:Exit current menu"));
                switch (menuOption) {
                    case 1:
                        store.DisplayTaskReport(taskStatus, developerDetails, taskName, taskDescription, taskID, time);
                        break;
                    case 2:
                        store.DisplayCompletedTasks(taskStatus, developerDetails, taskName, time);
                        break;
                    case 3:
                        store.DisplayTaskwithLongestDuration(time, developerDetails,taskName);
                        break;
                    case 4:
                        String searchTask = JOptionPane.showInputDialog("Enter Task Name to Search:");
                        store.SearchTaskbyTaskName(taskName, taskStatus,developerDetails, searchTask);
                        break;
                    case 5:
                        String searchDeveloper = JOptionPane.showInputDialog("Enter Developer Name to Search:");
                        store.SearchTaskByDeveloperdetails(developerDetails, taskStatus,taskName, searchDeveloper);
                        break;
                    case 6:
                        String deleteTask = JOptionPane.showInputDialog("Enter Task Name to Delete:");
                        store.deleteTasks(taskName, time, taskID, developerDetails, deleteTask, taskDescription);
                        break;
                    case 7:
                        exitCurrent=false;
                        break;
                }
                }
                break;

            case 3:
                JOptionPane.showMessageDialog(null, "GOODBYE!!!");
                System.exit(0);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Invalid option! Please choose the correct option.");
                break;
        }
    }
}

}
