

package com.mycompany.poepartoneandtwo;

import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class PoePartOneAndTwo {

    public static void main(String[] args) {
        // TODO code application logic here
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

        //part 2
        
      int option =0;
      int sum=0;
      String [] choose ={"TO DO","DONE","DOING"};
      Task task = new Task();
      JOptionPane.showMessageDialog(null,"Welcome to EasyKanBan: ");
      //used to keep the program running until the user 
      
      while(option!=3){
          option = Integer.parseInt(JOptionPane.showInputDialog("choose an option to proceed with \n 1: Add tasks \n 2: show report \n 3: QUIT"));
          //switch case
          switch(option){
              //first option on the menu
              case 1:
                  int size = Integer.parseInt(JOptionPane.showInputDialog("How many tasks you wish to capture?"));
                  String [] Taskname = new String [size];
                  String [] TaskDescription = new String [size];
                  String [] DeveloperDetails = new String [size];
                  int [] time= new int [size];
                  String [] taskID = new String[size];
                  
                  for(int y =0; y<size;y++){
                      Taskname[y]= JOptionPane.showInputDialog("Enter Task name:");
                      do{
                      TaskDescription [y] = JOptionPane.showInputDialog("Enter Task Description(characters should not exceed 50):");
                      }while(!task.checkDescription(TaskDescription[y]));
                      DeveloperDetails [y] = JOptionPane.showInputDialog("Enter Developer Details (Firstname and Lastname):");
                      time [y]= Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration:"));
                      taskID[y] = task.CreateTaskID(Taskname[y], y, DeveloperDetails [y]);
                      JOptionPane.showMessageDialog(null, "Task Id \n" + taskID[y]);
                        // used the JOption.show OptionDialog to allow the user to click the correct status instead of inserting a number
          int StatusMenu = Integer.parseInt(JOptionPane.showInputDialog("choose a status \n 1: To \n 2: Doing \n 3: Done"));
                 //declared and assigned a variablle the will display the choosen status
                  String statusoptions = " ";
                       // used a switch case to allow users to click the status of their choice
                      switch(StatusMenu){
                        
                       case 1:
                           
                           statusoptions = "To do";
                           break;
                           
                       case 2 :
                           statusoptions = "Done";
                           break;
                           
                       case 3 :
                           statusoptions = "Doing";
                           break;
                        
                        
                    }          
                JOptionPane.showMessageDialog(null, " Status \n" + statusoptions);
                task.printTaskDetails(statusoptions, DeveloperDetails [y], y, Taskname[y], DeveloperDetails [y], taskID[y] , time[y]);

                    //used a accumulator to calculate the total hours for all the tasks performed
                    sum += task.returnHours(time[y]);
                  }
                  JOptionPane.showMessageDialog(null,"The total hours of all the tasks performed: " + sum + "hrs");
              break;
              case 2:
                JOptionPane.showMessageDialog(null, "Coming Soon");  
              break;
              case 3:
               JOptionPane.showMessageDialog(null, "GOODBYE!!!");
               System.exit(0);

              break;
              default:
                  JOptionPane.showMessageDialog(null, "ivalid option plese choose the correct option");
              break;
          }     
      }
    }
}
