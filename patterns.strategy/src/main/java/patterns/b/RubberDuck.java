package patterns.b;

public class RubberDuck extends Duck implements Quackable {

    @Override
    public void quack() {
        System.out.println("кряк резиновой уточки");
    }

    @Override
    void display() {
        System.out.println("резиновая уточка");
    }

}
