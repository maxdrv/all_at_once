package patterns.c;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("Полет с помощью крыльев");
    }

}
