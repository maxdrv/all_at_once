package patterns.factory_method;

import patterns.factory_method.pizzas.Pizza;

/**
 * "Фабричный метод" Простой фабрики стал абстрактным методом PizzaStore
 *  он объявляется абстрактным что бы подклассы предоставили реализацию
 *
 *  Фабричный метод изолирует клиентский класс(в данном случае суперкласс PizzaStore)
 *  от информации о конкретном типе пиццы
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    protected abstract Pizza createPizza(String type);

}
