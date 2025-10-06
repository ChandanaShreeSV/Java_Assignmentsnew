import java.util.*;
class Task {
    String name;
    int priority; 
     Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    public String toString() {
        return name + " (Priority " + priority + ")";
    }
}
class TaskManager {
    private PriorityQueue<Task> queue = new PriorityQueue<>(Comparator.comparingInt(t -> t.priority));

    public void addTask(Task task) {
        queue.offer(task);
        System.out.println("Added: " + task);
    }
    public void processNextTask() {
        Task next = queue.poll();
        if (next != null) {
            System.out.println("Processing: " + next);
        } else {
            System.out.println("No tasks left.");
        }
    }
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        tm.addTask(new Task("Design", 3));
        tm.addTask(new Task("Testing", 2));
        tm.addTask(new Task("Deployment", 1));
        tm.addTask(new Task("Documentation", 5));
        tm.addTask(new Task("Coding", 4));

        tm.processNextTask();
        tm.processNextTask();
        tm.processNextTask();
    }
}
