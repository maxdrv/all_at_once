package patterns.a;

public abstract class Duck {

    void quack() {
        System.out.println("quack");
    }

    void swim() {
        System.out.println("swim");
    }

    abstract void display();

    void fly() {
        System.out.println("duck is flying");
    }

}
