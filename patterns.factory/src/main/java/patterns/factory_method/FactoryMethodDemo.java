package patterns.factory_method;

/**
 * Паттерн Фабричный метод определяет интерфейс создания объекта,
 * но позволяет субклассам выбрать класс создаваемого экземпляра
 * Таким образом фабричный метод делегирует операцию создания экземпляра подклассам
 */
public class FactoryMethodDemo {

    public static void main(String[] args) {

        PizzaStore nyStore = new NYPizzaStore();
        nyStore.orderPizza("cheese");

        PizzaStore chicagoStore = new ChicagoPizzaStore();
        chicagoStore.orderPizza("cheese");

    }

}
