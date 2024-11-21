
package com.mycompany.poepartoneandtwo;

public class LOGIN {
   private String firstname;
    private String lastname;
    private String username;
    private String password;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkUsername(String username) {
        if (username.length() <= 5 && username.contains("_")) {
            
            setUsername(username); // Use setter after validation
            return true;
        } else {
            System.out.println("Username is invalid. Ensure it contains an underscore and is no more than 5 characters long.");
            return false;
        }
    }

    public boolean checkPassword(String pass) {
        boolean containsSpecial = false;
        boolean containsLetters = false;
        boolean containsNumber = false;

        for (int i = 0; i < pass.length(); i++) {
            char ch = pass.charAt(i);
            if (Character.isUpperCase(ch)) {
                containsLetters = true;
            } else if (Character.isDigit(ch)) {
                containsNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                containsSpecial = true;
            }
        }

        if (containsSpecial && containsLetters && containsNumber) {
           
            setPassword(pass); // Use setter after validation
            return true;
        } else {
            System.out.println("Password is not successfully captured. Please ensure it meets the requirements.");
            return false;
        }
    }

    public String registerUser(String firstName, String lastName, String username, String password) {
        setFirstname(firstName);
        setLastname(lastName);
        
        if (!checkUsername(username)) {
            return "Username is not successfully captured.";
        }
        if (!checkPassword(password)) {
            return "Password is not successfully captured.";
        }
        
        return "The conditions have been met, and the user has registered successfully.";
    }

    public boolean loginUser(String username, String password) {
        if (username.equals(getUsername()) && password.equals(getPassword())) {
            System.out.println("Login successful!");
            return true;
        } else {
           
            return false;
        }
    }

    public String returnLoginStatus(boolean loginSuccessful) {
        if (loginSuccessful) {
            return "Welcome " + getFirstname() + " " + getLastname() + ". It is great to see you again.";
        } else {
            return "Username or password incorrect. Try again.";
        }
 } 
}
