package com.ironhack;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findByName(String name) {
        if (name == null || !name.matches("^[a-zA-Z]+\\s[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Name must be a properly formatted string as 'firstName lastName'.");
        }
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public Person clone(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("The object to be cloned must be a Person instance.");
        }
        return new Person(0, person.getName(), person.getAge(), person.getOccupation());
    }

    public void writePersonToFile(Person person, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(person.toString());
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
