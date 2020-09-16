package patterns.b;

public class MallardDuck extends Duck implements Quackable, Flyable{

    @Override
    void display() {
        System.out.println("mallard duck is displayed");
    }

    @Override
    public void fly() {
        System.out.println("mallard duck fly");
    }

    @Override
    public void quack() {
        System.out.println("mallard duck quack");

    }
}
