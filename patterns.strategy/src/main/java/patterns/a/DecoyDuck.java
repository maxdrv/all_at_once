package patterns.a;

public class DecoyDuck extends Duck {

    @Override
    void quack() {
        System.out.println("деревянная утка не умеет квакать");
    }

    @Override
    void fly() {
        System.out.println("деревянная утка не умеет летать");
    }

    @Override
    void display() {
        System.out.println("деревянная утка");
    }
}
