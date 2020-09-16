package patterns.smth.pizzas;

import patterns.smth.PizzaIngredientFactory;

public class ClamPizza extends Pizza {

    PizzaIngredientFactory factory;

    public ClamPizza(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = factory.createDough();
        sauce = factory.createSource();
        cheese = factory.createCheese();
        clams = factory.createClam();
    }
}
