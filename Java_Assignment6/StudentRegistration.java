import java.util.*;
class StudentRegistration {
    private Map<String, String> students = new HashMap<>();

    public void addStudent(String id, String name) {
        if (students.containsKey(id)) {
            System.out.println("Duplicate ID not allowed: " + id);
        } else {
            students.put(id, name);
            System.out.println("Student added: " + name);
        }
    }
     public String findStudent(String id) {
        return students.getOrDefault(id, "Student not found");
    }
    public static void main(String[] args) {
        StudentRegistration reg = new StudentRegistration();
        reg.addStudent("101", "Alice");
        reg.addStudent("102", "Bob");
        reg.addStudent("103", "Charlie");
        reg.addStudent("104", "David");
        reg.addStudent("105", "Eve");

        System.out.println("Find 103: " + reg.findStudent("103"));
        System.out.println("Find 200: " + reg.findStudent("200"));
    }
}
