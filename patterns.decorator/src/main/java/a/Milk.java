package a;

public class Milk extends CondimentDecorator {

    private Beverage beverage;
    private String description = ", milk";

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + .10;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + description;
    }
}
