package a;

public class Mocha extends CondimentDecorator {

    private Beverage beverage;
    private String description = ", mocha";

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + .20;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + description;
    }

}
