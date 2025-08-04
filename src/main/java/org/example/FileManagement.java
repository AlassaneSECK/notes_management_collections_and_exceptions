package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileManagement {
    public static void saveToFile(Map<Student, ArrayList<Double>> notesMap, String fileName){
        try(PrintWriter writer = new PrintWriter(new File(fileName))){
            for(Map.Entry<Student, ArrayList<Double>> entry : notesMap.entrySet()){
                Student student = entry.getKey();
                ArrayList<Double> notes = entry.getValue();
                writer.print(student.getFirstName() + ";" + student.getLastName() + ";");
                for (int i = 0; i < notes.size(); i++) {
                    writer.print(notes.get(i));
                    if(i != notes.size() - 1) writer.print(",");
                }
            }
            System.out.println("Save complete.");
        }catch (Exception e){
            System.err.println("Error saving notes to file" + e.getMessage());
        }
    }

    public static Map<Student, ArrayList<Double>> restoreFromFile(String fileName){
        Map<Student, ArrayList<Double>> notesMap = new HashMap<>();
        try(Scanner fileScanner = new Scanner(new File(fileName))){
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                String[] lineSplit = line.split(";");
                if(lineSplit.length == 2){
                    String firstName = lineSplit[0];
                    String lastName = lineSplit[1];
                } else if (lineSplit.length == 3) {
                    String firstName = lineSplit[0];
                    String lastName = lineSplit[1];
                    String[] notesStr = lineSplit[2].split(",");
                    ArrayList<Double> notes = new ArrayList<>();
                    for(String noteStr : notesStr){
                        if(!noteStr.isEmpty()) notes.add(Double.parseDouble(noteStr));
                    }
                    Student student = new Student(firstName, lastName);
                    notesMap.put(student, notes);
                }
            }
            System.out.println("Load complete.");
        } catch (FileNotFoundException e) {
            System.err.println("Error restoring notes from file" + e.getMessage());
        }
        return notesMap;
    }
}
