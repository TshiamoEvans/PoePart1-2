/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class Login {
   //used the private access modifier to declare my variables
    private String name;
    private String surname;
    private String password;
    private String username;
    //used public access modifier to declare my boolean variable so that i can be to use then in other methods when comparing
    public  boolean correct=true;
    public boolean verify=false;
    public boolean check=false;
    //used getters to return my variables
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    
    //meethod that captures the user detatils when they are registering  
    public void Capture(){
        //used a scanner to prompt the user and allow for their input
       Scanner cons = new Scanner(System.in); 
        System.out.print("Enter your name:");
        //used the this constructor to refer to the variables i declared using the private access specifier
        this.name=cons.nextLine();
        
        System.out.print("Enter your surname:");
        //used the this constructor to refer to the variables i declared using the private access specifier
        this.surname=cons.nextLine();
        //used a do while loop to reprompt the user if the username does not meet the requirements
        do{
        System.out.print("Enter your username(username must have up to 5 character and must contain a underscore):");
        this.username=cons.nextLine();
        }while(!CHECKusername(this.username));
        //used a do while loop to reprompt the user if the password does not meet the requirements
        do{
        System.out.print("Enter password(password must 8 characters or more and must conytain Special characters, numbers and an uppercase):");
        this.password=cons.nextLine();
        
        }while(!CheckPassword(this.password));
    }
    //method that returns a value and it checks for the username requirements
    public boolean CHECKusername(String user){
        
        if(user.length()<=5 && user.contains("_")){
            
            verify=true;
        }else{
            System.out.println("username is not successfully captured please ensure that it contains underscores and has up to 5 characters");
            verify=false;
        }
        return verify;
    }
    //method that returns a value and it checks for the password complexity
    public boolean CheckPassword(String passs){
        boolean containSpecial=false;
        boolean containLtters=false;
        boolean containnum=false;
        
        
        for(int x=0; x<passs.length();x++){
            char pie= passs.charAt(x);
            if(Character.isUpperCase(pie)){
                containLtters=true;
            } else if(Character.isDigit(pie)){
                containnum=true;
            } else if(!Character.isLetterOrDigit(pie)){
                containSpecial=true;
            }
        }
        if(containSpecial&& containLtters&& containnum){
            
            check =true;
        }else{
            System.out.println("Password is not successfully captured, please ensure thatt your password meets the requirements");
            check=false;
        }
         
        return check;
    }
    public String registerUser(){
           
        if(!verify && check){
            System.out.println("username is  not succesfully captured");
        }else if(verify && !check){
            System.out.println("password is not successfully capture");  
        }else{
            System.out.println("Congats you have successfully registered \n**********************************************************8");
        }
        
        
       return ""; 
    }
    public boolean loginUser(){
            
            Scanner nameSc = new Scanner(System.in);
            System.out.println("Welcome user please enter the following details to log in");
            
            do{
             System.out.print("Enter your username:");
            String Username= nameSc.nextLine();
           
             System.out.print("Enter your password:");
            String secondpassword = nameSc.nextLine();
           
            
             if(Username.equals(this.username) && secondpassword.equals(this.password)){
                 
                 correct = true;
             }
             else{
              System.out.println("USERNAME OR PASSWORD INCORRECT, PLEASE TRY AGAIN!");
                 correct = false;
             }
             
            }while(!correct);
            
             return correct;

        }
    
    public  String returnLoginStatus(){
        
            if(correct){
                System.out.println("WELCOME To EASYKANBAN" + " "+ getName()  +" " + getSurname());
             
            }
            else{
                
                System.out.println("USERNAME OR PASSWORD INCORRECT, PLEASE TRY AGAIN!");
            }
                
        
            return "";
        }  
}
