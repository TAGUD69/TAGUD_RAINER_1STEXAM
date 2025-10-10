
package studentmanager;

import java.util.Scanner;

public class StudentManager {
    private final Student[] students;
    private int studentCount;
    private final Scanner scanner;
    private static final int MAX_STUDENTS = 50;
    
    public StudentManager() {
        students = new Student[MAX_STUDENTS];
        studentCount = 0;
        scanner = new Scanner(System.in);
    }
    
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.runProgram();
    }
    
    public void runProgram() {
        displayHeader();
        mainLoop();
        displayAllRecords();
        searchFeature();
        closeProgram();
    }
    
    private void displayHeader() {
        System.out.println("==========================================");
        System.out.println("    STUDENT ENROLLMENT SYSTEM");
        System.out.println("  UNIVERSITY OF MINDANAO DIGOS CAMPUS");
        System.out.println("==========================================");
    }
    
    private void mainLoop() {
        boolean continueAdding = true;
        
        while (continueAdding && studentCount < MAX_STUDENTS) {
            addNewStudent();
            
            if (studentCount < MAX_STUDENTS) {
                System.out.print("\nAdd another student? (Y/N): ");
                String choice = scanner.nextLine().trim();
                
                if (choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("NO")) {
                    continueAdding = false;
                }
            } else {
                System.out.println("\nMaximum student capacity reached (" + MAX_STUDENTS + " students)");
            }
        }
    }
    
    private void addNewStudent() {
        System.out.println("\n--- Enter Student Details ---");
        
        System.out.print("Full Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Address: ");
        String address = scanner.nextLine();
        
        System.out.print("Grade Level (7-10): ");
        int gradeLevel = getValidGradeLevel();
        
        System.out.print("Gender (Male/Female): ");
        String gender = scanner.nextLine();
        
        System.out.print("General Weighted Average (GWA): ");
        double gwa = getValidGWA();
        
        Student newStudent = new Student(name, address, gradeLevel, gender, gwa);
        students[studentCount] = newStudent;
        studentCount++;
        
        System.out.println("\n✓ Student record added successfully!");
        System.out.println("Total students enrolled: " + studentCount);
        newStudent.displayInfo();
    }
    
    private int getValidGradeLevel() {
        while (true) {
            try {
                int grade = scanner.nextInt();
                scanner.nextLine();
                
                if (grade >= 7 && grade <= 10) {
                    return grade;
                } else {
                    System.out.print("Please enter grade level between 7-10: ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine();
            }
        }
    }
    
    private double getValidGWA() {
        while (true) {
            try {
                double gwa = scanner.nextDouble();
                scanner.nextLine();
                
                if (gwa >= 0 && gwa <= 100) {
                    return gwa;
                } else {
                    System.out.print("Please enter GWA between 0-100: ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine();
            }
        }
    }
    
    private void displayAllRecords() {
        System.out.println("\n========================================");
        System.out.println("        ALL STUDENT RECORDS");
        System.out.println("========================================");
        System.out.println("Total Students: " + studentCount);
        
        if (studentCount == 0) {
            System.out.println("No student records available.");
            return;
        }
        
        for (int i = 0; i < studentCount; i++) {
            System.out.println("\nStudent #" + (i + 1));
            students[i].displayInfo();
        }
    }
    
    private void searchFeature() {
        if (studentCount == 0) {
            System.out.println("No students to search.");
            return;
        }
        
        System.out.print("\nSearch student by name (or type 'exit' to skip): ");
        String searchName = scanner.nextLine();
        
        if (searchName.equalsIgnoreCase("exit")) {
            return;
        }
        
        boolean found = false;
        System.out.println("\n--- Search Results ---");
        
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getFullName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println("✓ Match found:");
                students[i].displayInfo();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No students found with name containing: '" + searchName + "'");
        }
    }
    
    private void closeProgram() {
        scanner.close();
        System.out.println("\n==========================================");
        System.out.println("  Program completed successfully!");
        System.out.println("  Total students processed: " + studentCount);
        System.out.println("  Thank you for using the system!");
        System.out.println("==========================================");
    }
}