import java.util.Random;
import java.util.Scanner;

abstract class Animal {
    protected String name;
    protected double jumpWeight;
    protected double runLength;
    protected double swimLength;
    public static Random rand = new Random();
    String[] name_anim = {"David Jhonson", "Mura", "Snezhock", "XXX.RUN", "biba", "bobich", "dva4", "qeqoqeq"};
    int index = rand.nextInt(name_anim.length);
    String random_name = name_anim[index];

    public Animal(String name, double jumpWeight, double runLength, double swimLength){
        this.name = name;
        this.jumpWeight = jumpWeight;
        this.runLength = runLength;
        this.swimLength = swimLength;
    }

    public Animal() {
        this.name = random_name;
    }

    public void animalInfo(){
        System.out.println("Кликуха: " + this.name);
        System.out.println("Высота прыжка:" + this.jumpWeight);
        System.out.println("Длина пробежки:" + this.runLength);
        System.out.println("Длина возможного проплыва:" + this.swimLength);
    }

    public boolean jump(double distance){
        return this.jumpWeight >= distance;
    }

    public boolean run(double distance){
        return this.runLength >= distance;
    }

    public boolean swim(double distance){
        return this.swimLength >= distance;
    }
}

class Dog extends Animal{
    public Dog(){
        super();
        this.jumpWeight = rand.nextDouble(0.00001, 0.5);
        this.runLength = rand.nextDouble(1, 500);
        this.swimLength = rand.nextDouble(1, 10);
    }

    public Dog(String name, double jumpWeight, double runLength, double swimLength){
        super(name, jumpWeight, runLength, swimLength);
    }
}

class Cat extends Animal{
    public Cat(){
        super();
        this.jumpWeight = rand.nextDouble(0.1, 2);
        this.runLength = rand.nextDouble(1, 200);
        this.swimLength = 0;
    }

    public Cat(String name, double jumpWeight, double runLength, double swimLength){
        super(name, jumpWeight, runLength, swimLength);
    }
}

public class Main{
    public static Scanner inp = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Введите кол-во животных (кол-во каждого вида одинаково (при 1 будет 1 кот и 1 собака)): ");
        int amount_animals = inp.nextInt();
        Dog[] dogs = new Dog[amount_animals];
        Cat[] cats = new Cat[amount_animals];


        for (int i = 0; i < amount_animals; i++) {
            dogs[i] = new Dog();
            cats[i] = new Cat();
        }

        for (int i = 0; i < amount_animals; i++) {
            dogs[i].animalInfo();
            System.out.println(dogs[i].jump(10.1));
            System.out.println("---------------------------------");
        }

        for (int i = 0; i < amount_animals; i++) {
            cats[i].animalInfo();
            System.out.println(cats[i].run(4.8));
            System.out.println("---------------------------------");
        }
    }
}
