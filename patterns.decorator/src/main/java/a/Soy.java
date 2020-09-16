package a;

public class Soy extends CondimentDecorator {

    private Beverage beverage;
    private String description = ", soy";

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + .15;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + description;
    }

}
