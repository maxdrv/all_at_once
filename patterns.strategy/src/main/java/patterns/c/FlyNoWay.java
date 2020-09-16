package patterns.c;

public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("Не умеет летать");
    }

}
