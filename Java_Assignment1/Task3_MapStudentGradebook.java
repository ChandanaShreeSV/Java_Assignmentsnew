import java.util.*;

public class Task3_MapStudentGradebook {
    public static void main(String[] args) {
        Gradebook gb = new Gradebook();
        gb.addStudent("John");
        gb.addGrade("John", 80);
        gb.addGrade("John", 90);
        gb.calculateAverage("John");
        gb.displayAll();
    }
}

class Gradebook {
    private Map<String, List<Integer>> grades;

    public Gradebook() {
        grades = new HashMap<>();
        System.out.println("CREATE Time Complexity: O(1)");
    }

    public void addStudent(String name) {
        grades.putIfAbsent(name, new ArrayList<>());
        System.out.println("INSERT Time Complexity: O(1)");
    }

    public void addGrade(String name, int grade) {
        grades.get(name).add(grade);
        System.out.println("INSERT Time Complexity: O(1)");
    }

    public void calculateAverage(String name) {
        List<Integer> g = grades.get(name);
        int sum = 0;
        for (int mark : g) sum += mark;
        double avg = (double) sum / g.size();
        System.out.println(name + " Average: " + avg);
        System.out.println("SEARCH Time Complexity: O(1)");
    }

    public void displayAll() {
        System.out.println("Gradebook: " + grades);
    }
}
