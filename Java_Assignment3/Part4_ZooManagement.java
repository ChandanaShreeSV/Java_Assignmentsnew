abstract class Animal {
    protected String name;
    protected int age;
    private static int counter = 0;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
    }

    public void eat() { System.out.println(name + " is eating."); }
    public abstract void makeSound();
    public abstract void move();
    public static int getAnimalCount() { return counter; }
}

interface Flyable { void fly(); }
interface Swimmable { void swim(); }

class Bird extends Animal implements Flyable {
    public Bird(String name, int age) { super(name, age); }
    public void makeSound() { System.out.println(name + " chirps."); }
    public void move() { fly(); }
    public void fly() { System.out.println(name + " is flying."); }
}

class Fish extends Animal implements Swimmable {
    public Fish(String name, int age) { super(name, age); }
    public void makeSound() { System.out.println(name + " blubs."); }
    public void move() { swim(); }
    public void swim() { System.out.println(name + " is swimming."); }
}

class Duck extends Animal implements Flyable, Swimmable {
    public Duck(String name, int age) { super(name, age); }
    public void makeSound() { System.out.println(name + " quacks."); }
    public void move() { System.out.println(name + " waddles."); }
    public void fly() { System.out.println(name + " is flying."); }
    public void swim() { System.out.println(name + " is swimming."); }
}

class Cat extends Animal {
    public Cat(String name, int age) { super(name, age); }
    public void makeSound() { System.out.println(name + " meows."); }
    public void move() { System.out.println(name + " is walking."); }
}

class ZooKeeper {
    public void feedAllAnimals(Animal[] animals) {
        for (Animal a : animals) a.eat();
    }
    public void makeAnimalSound(Animal animal) { animal.makeSound(); }
}

public class Part4_ZooManagement {
    public static void main(String[] args) {
        Animal[] animals = {
            new Bird("Parrot", 2),
            new Fish("Goldfish", 1),
            new Duck("Donald", 3),
            new Cat("Whiskers", 4)
        };

        ZooKeeper zk = new ZooKeeper();
        zk.feedAllAnimals(animals);
        for (Animal a : animals) {
            zk.makeAnimalSound(a);
            a.move();
        }
        System.out.println("Total animals: " + Animal.getAnimalCount());
    }
}