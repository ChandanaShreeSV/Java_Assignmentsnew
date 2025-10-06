abstract class Animal {
    protected String name;
    protected int age;
    protected static int counter = 0;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
    }
    public void eat() {
        System.out.println(name + " is eating.");
    }
    public abstract void makeSound();
    public abstract void move();
}
interface Flyable {
    void fly();
}interface Swimmable {
    void swim();
}
class Bird extends Animal implements Flyable {
    public Bird(String name, int age) {
        super(name, age);
    }
    public void makeSound() {
        System.out.println(name + " chirps.");
    }
    public void move() {
        System.out.println(name + " hops around.");
    }
     public void fly() {
        System.out.println(name + " is flying.");
    }
}
class Fish extends Animal implements Swimmable {
    public Fish(String name, int age) {
        super(name, age);
    }
    public void makeSound() {
        System.out.println(name + " makes bubble sounds.");
    }
    public void move() {
        System.out.println(name + " swims forward.");
    }
    public void swim() {
        System.out.println(name + " is swimming fast.");
    }
}
class Duck extends Animal implements Flyable, Swimmable {
    public Duck(String name, int age) {
        super(name, age);
    }
    public void makeSound() {
        System.out.println(name + " quacks.");
    }
    public void move() {
        System.out.println(name + " waddles.");
    }
    public void fly() {
        System.out.println(name + " flies short distances.");
    }
    public void swim() {
        System.out.println(name + " swims in the pond.");
    }
}
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }
     public void makeSound() {
        System.out.println(name + " meows.");
    }
    public void move() {
        System.out.println(name + " walks silently.");
    }
}
class ZooKeeper {
    public void feedAllAnimals(Animal[] animals) {
        for (Animal a : animals) {
            a.eat();
        }
    }
    public void makeAnimalSound(Animal animal) {
        animal.makeSound();
    }
}
public class ZooManagementSystem {
    public static void main(String[] args) {
        Animal bird = new Bird("Parrot", 2);
        Animal fish = new Fish("Goldfish", 1);
        Animal duck = new Duck("Donald", 3);
        Animal cat = new Cat("Kitty", 4);

        Animal[] animals = {bird, fish, duck, cat};

        ZooKeeper keeper = new ZooKeeper();
        keeper.feedAllAnimals(animals);

        System.out.println("\nMaking Sounds");
        for (Animal a : animals) {
            keeper.makeAnimalSound(a);
        }
        System.out.println("\nSpecial Abilities");
        ((Bird) bird).fly();
        ((Fish) fish).swim();
        ((Duck) duck).fly();
        ((Duck) duck).swim();
         System.out.println("Total animals created: " + Animal.counter);
    }
}
