package patterns.c;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Кваканье настоящей утки");
    }
}
