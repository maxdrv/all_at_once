package patterns.factory_method;

import patterns.factory_method.pizzas.ChicagoStyleCheesePizza;
import patterns.factory_method.pizzas.ChicagoStyleGreekPizza;
import patterns.factory_method.pizzas.ChicagoStylePepperoniPizza;
import patterns.factory_method.pizzas.Pizza;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza;
        switch (type) {
            case "cheese":
                pizza = new ChicagoStyleCheesePizza();
                break;
            case "greek":
                pizza = new ChicagoStyleGreekPizza();
                break;
            case "pepperoni":
                pizza = new ChicagoStylePepperoniPizza();
                break;
            default:
                throw new RuntimeException("Не могу создать такую пиццу");
        }
        return pizza;
    }
}
