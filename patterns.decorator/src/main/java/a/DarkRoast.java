package a;

public class DarkRoast extends Beverage {

    private String description = "dark roast coffee";

    @Override
    public double cost() {
        return .99;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
