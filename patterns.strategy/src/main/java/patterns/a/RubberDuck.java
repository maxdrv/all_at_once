package patterns.a;

public class RubberDuck extends Duck {

    @Override
    void quack() {
        System.out.println("кряк резиновой уточки");
    }

    @Override
    void display() {
        System.out.println("резиновая уточка");
    }

    @Override
    void fly() {
        System.out.println("резиновая уточка на самом деле летать не умеет");
    }
}
