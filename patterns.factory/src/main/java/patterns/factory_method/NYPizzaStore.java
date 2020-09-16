package patterns.factory_method;

import patterns.factory_method.pizzas.NyStyleCheesePizza;
import patterns.factory_method.pizzas.NyStyleGreekPizza;
import patterns.factory_method.pizzas.NyStylePepperoniPizza;
import patterns.factory_method.pizzas.Pizza;

public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
            Pizza pizza;
            switch (type) {
                case "cheese":
                    pizza = new NyStyleCheesePizza();
                    break;
                case "greek":
                    pizza = new NyStyleGreekPizza();
                    break;
                case "pepperoni":
                    pizza = new NyStylePepperoniPizza();
                    break;
                default:
                    throw new RuntimeException("Не могу создать такую пиццу");
            }
            return pizza;
    }

}
