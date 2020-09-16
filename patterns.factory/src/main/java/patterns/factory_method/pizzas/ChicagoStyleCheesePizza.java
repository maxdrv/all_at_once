package patterns.factory_method.pizzas;

public class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza() {
        name = "Chicago style cheese pizza";
        dough = "Extra thick crust dough";
        sauce = "Plum tomato sauce";

        toppings.add("shredded mozzarella cheese");
    }

    @Override
    public void cut() {
        System.out.println("Cutting pizza into square slices");
    }
}
