package a;

public class Whip extends CondimentDecorator {

    private Beverage beverage;
    private String description = ", whip";

    public Whip(Beverage beverage) {
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
