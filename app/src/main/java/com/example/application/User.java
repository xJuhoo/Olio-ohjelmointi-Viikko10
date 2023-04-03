package com.example.application;

import java.util.ArrayList;
import java.util.Comparator;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;
    private int image;
    // New list for completed degrees
    private ArrayList<String> completedDegrees = new ArrayList<>();

    // Public constructor
    public User(String firstName, String lastName, String email, String degreeProgram, int image, ArrayList<String> completedDegrees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.image = image;
        this.completedDegrees = completedDegrees;
    }

    // Getters for all user information
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getDegreeProgram() {
        return this.degreeProgram;
    }

    public int getImage() {
        return this.image;
    }

    public ArrayList<String> getDegrees() {
        return completedDegrees;
    }

    // Method for rearranging the list
    public static final Comparator<User> comparator = new Comparator<User>() {
        @Override
        public int compare(User firstUser, User secondUser) {
            return firstUser.lastName.compareTo(secondUser.lastName);
        }
    };
}

