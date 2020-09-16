package a;

public class Decaf extends Beverage {

    private String description = "decaf coffee";

    @Override
    public double cost() {
        return 1.05;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
