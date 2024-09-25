/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1;

/**
 *
 * @author RC_Student_lab
 */
public class PoePart1 {

    public static void main(String[] args) {
        //Object calling 
         Login log = new Login();
         //displayed a welcoming messsage
         System.out.println("Welcome to easy kanban");
        //called the methods
        log.Capture();
        log.registerUser();
        log.loginUser();
        log.returnLoginStatus();
    }
}
