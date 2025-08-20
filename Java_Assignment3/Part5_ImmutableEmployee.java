final class Employee {
    private final int id;
    private final String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() { return id; }
    public String getName() { return name; }
}

public class Part5_ImmutableEmployee {
    public static void main(String[] args) {
        Employee e = new Employee(1, "Alice");
        System.out.println("ID: " + e.getId());
        System.out.println("Name: " + e.getName());
    }
}