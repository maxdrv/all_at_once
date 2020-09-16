package a;

public class HouseBlend extends Beverage {

    private String description = "house blend coffee";

    @Override
    public double cost() {
        return .89;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
