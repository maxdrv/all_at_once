package patterns.smth;

import patterns.smth.pizzas.CheesePizza;
import patterns.smth.pizzas.ClamPizza;
import patterns.smth.pizzas.Pizza;

public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        switch (item) {
            case "cheese":
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("New York Style Cheese Pizza");
                break;
            case "veggie":
                pizza = new ClamPizza(ingredientFactory);
                pizza.setName("New York Style Clam Pizza");
                break;
            default:
                throw new IllegalArgumentException("Таких пицц нет");
        }
        return pizza;
    }
}
