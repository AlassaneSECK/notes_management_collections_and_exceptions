package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<Student, ArrayList<Double>> notesMap = new HashMap<>();
        int choice;
        while(true){
            System.out.println("-- NOTES MANAGER --");
            System.out.println("1. Add student");
            System.out.println("2. Add notes for a student");
            System.out.println("3. Display a student's notes");
            System.out.println("4. Calculate a student's average");
            System.out.println("5. Show all students and their notes");
            System.out.println("6. Exit");

            System.out.println("Enter your choice: ");
            try {
                choice = Integer.parseInt(input.nextLine());
            }catch (NumberFormatException e){
                System.err.println("Invalid input");
                continue;
            }
            if(choice==6){
                break;
            }
            switch(choice){
                case 1:
                    String firstName;
                    while (true) {
                        System.out.println("Enter the student's first name: ");
                        firstName = input.nextLine();
                        if (firstName.length() < 2) {
                            System.out.println("First name too short.");
                            continue;
                        }
                        if (!firstName.matches("^[^0-9]*$")) {
                            System.out.println("First name should not contain digits.");
                            continue;
                        }
                        break; // prénom valide
                    }

                    String lastName;
                    while (true) {
                        System.out.println("Enter the student's last name: ");
                        lastName = input.nextLine();
                        if (lastName.length() < 2) {
                            System.out.println("Last name too short.");
                            continue;
                        }
                        if (!lastName.matches("^[^0-9]*$")) {
                            System.out.println("Last name should not contain digits.");
                            continue;
                        }
                        break;
                    }

                    Student student = new Student(firstName, lastName);
                    if (!notesMap.containsKey(student)) {
                        notesMap.put(student, new ArrayList<>());
                        System.out.println("Student has been added.");
                    } else {
                        System.out.println("Student already exists.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the first name for a student: ");
                    String studentName = input.nextLine();
                    System.out.println("Enter the last name for a student: ");
                    String studentLastName = input.nextLine();
                    Student theStudent = new Student(studentName, studentLastName);
                    if (notesMap.containsKey(theStudent)) {
                        System.out.println("how many notes do you want to enter");
                        int nbrNotes = Integer.parseInt(input.nextLine());
                        for (int i = 0; i < nbrNotes; i++) {
                            System.out.println("Enter note " + (i + 1) + ": ");
                            double note = Double.parseDouble(input.nextLine());
                            notesMap.get(theStudent).add(note);
                        }
                    }else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.println("-- ALL STUDENTS WITH NOTES --");
                    for (Map.Entry<Student, ArrayList<Double>> entry : notesMap.entrySet()) {
                        System.out.println(entry.getKey().getFirstName() + " " + entry.getKey().getLastName() + " - " + entry.getValue());
                    }
                    break;
                case 4:
                    System.out.println("-- ALL STUDENTS WITH AVERAGE NOTES --");
                    for (Map.Entry<Student, ArrayList<Double>> entry : notesMap.entrySet()) {
                        System.out.println(entry.getKey().getFirstName() + " " + entry.getKey().getLastName() + " average: ");
                        double general_average = 0;
                        for (Double note : entry.getValue()) {
                            general_average += note;
                        }
                        general_average /= entry.getValue().size();
                        System.out.println(general_average);
                    }
                    break;
            }
        }
        input.close();
    }
}