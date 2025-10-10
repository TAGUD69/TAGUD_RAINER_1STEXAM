package studentmanager;

public class Student {
    private final String fullName;
    private final String address;
    private final int gradeLevel;
    private final String gender;
    private final double gwa;
    
    public Student(String fullName, String address, int gradeLevel, String gender, double gwa) {
        this.fullName = fullName;
        this.address = address;
        this.gradeLevel = gradeLevel;
        this.gender = gender;
        this.gwa = gwa;
    }
    
    public String getRemarks() {
        if (gwa >= 75.0) {
            return "PASSED";
        } else {
            return "FAILED";
        }
    }
    
    public void displayInfo() {
        System.out.println("Full Name: " + fullName);
        System.out.println("Address: " + address);
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println("Gender: " + gender);
        System.out.println("GWA: " + gwa + "%");
        System.out.println("Remarks: " + getRemarks());
        System.out.println("---------------------------");
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public String getAddress() {
        return address;
    }
    
    public int getGradeLevel() {
        return gradeLevel;
    }
    
    public String getGender() {
        return gender;
    }
    
    public double getGwa() {
        return gwa;
    }
}