package a;

public class Espresso extends Beverage {
    private String description = "espresso";

    @Override
    public double cost() {
        return 1.99;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
