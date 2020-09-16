package patterns.b;

public class RedheadDuck extends Duck implements Quackable, Flyable{



    @Override
    void display() {
        System.out.println("redhead duck is displayed");
    }

    @Override
    public void fly() {
        System.out.println("redhead duck fly");
    }

    @Override
    public void quack() {
        System.out.println("redhead duck quack");

    }
}
