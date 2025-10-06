class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String msg) {
        super(msg);
    }
}
class InvalidIdException extends RuntimeException {
    public InvalidIdException(String msg) {
        super(msg);
    }
}
class StudentManagement {
    private String[] students = {"Alice", "Bob", "Charlie"};
    public String getStudent(int id) throws StudentNotFoundException {
        if (id < 0) {
            throw new InvalidIdException("ID cannot be negative");
        }
        if (id >= students.length) {
            throw new StudentNotFoundException("Student not found");
        }
        return students[id];
    }
     public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
         try {
            System.out.println(sm.getStudent(1)); 
            System.out.println(sm.getStudent(5)); 
        } catch (StudentNotFoundException | InvalidIdException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Search finished.");
        }
 // runtime exception 
        System.out.println(sm.getStudent(-2));
    }
}
