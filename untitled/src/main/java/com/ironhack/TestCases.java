package com.ironhack;

import java.io.IOException;

public class TestCases {
    public static void main(String[] args) {
        // Test setAge method
        try {
            Person p1 = new Person(1, "John Doe", 25, "Engineer");
            p1.setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected output: Age cannot be less than 0.
        }

        // Test findByName method with properly formatted name
        PersonsList personsList = new PersonsList();
        Person p1 = new Person(1, "John Doe", 25, "Engineer");
        personsList.addPerson(p1);
        Person p2 = personsList.findByName("John Doe");
        System.out.println(p2.getName()); // Expected output: John Doe

        // Test findByName method with improperly formatted name
        try {
            p2 = personsList.findByName("JohnDoe");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected output: Name must be a properly formatted string as 'firstName lastName'.
        }

        // Test clone method
        Person p3 = personsList.clone(p1);
        System.out.println(p3.getId()); // Expected output: 0
        System.out.println(p3.getName()); // Expected output: John Doe
        System.out.println(p3.getAge()); // Expected output: 25
        System.out.println(p3.getOccupation()); // Expected output: Engineer

        // Test writePersonToFile method
        String filePath = "person.txt";
        personsList.writePersonToFile(p1, filePath);
        try (java.util.Scanner fileScanner = new java.util.Scanner(new java.io.File(filePath))) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
        // Expected output:
        // ID: 1
        // Name: John Doe
        // Age: 25
        // Occupation: Engineer
    }
}
