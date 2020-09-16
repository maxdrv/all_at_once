package patterns.smth;

import patterns.smth.ingredients.*;

/**
 * Dough - тесто
 */
public interface PizzaIngredientFactory {

    Dough createDough();

    Sauce createSource();

    Cheese createCheese();

    Veggies[] createVeggies();

    Pepperoni createPepperoni();

    Clams createClam();

}
