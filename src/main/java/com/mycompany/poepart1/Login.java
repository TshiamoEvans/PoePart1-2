/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

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
}
