package patterns.simple_factory;

import patterns.simple_factory.pizzas.CheesePizza;
import patterns.simple_factory.pizzas.GreekPizza;
import patterns.simple_factory.pizzas.PepperoniPizza;
import patterns.simple_factory.pizzas.Pizza;

/**
 * Что дает использование Простой Фабрики? Ведь по сути мы просто перекладываем создающий код в другое место
 *
 * note: простая фабрика скорее идиома программирования, нежели паттерн
 *
 * Теперь фабрика может быть использована не только классом
 * {@link patterns.simple_factory.PizzaStore}
 *
 * Но и другими классами, например это может быть PizzaShopMenu или HomeDelivery
 *
 * Т.о. простая фабрика инкапсулирует создание объекта в одном месте
 * А так же исключается создание экземпляров в клиентском коде
 *
 */
public class SimplePizzaFactory {

    Pizza createPizza(String type) {
        Pizza pizza;
        switch (type) {
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "greek":
                pizza = new GreekPizza();
                break;
            case "pepperoni":
                pizza = new PepperoniPizza();
                break;
            default:
                throw new RuntimeException("Не могу создать такую пиццу");
        }
        return pizza;
    }

}
