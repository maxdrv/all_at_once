package patterns.factory_method.pizzas;

public class NyStyleCheesePizza extends Pizza {

    public NyStyleCheesePizza() {
        name = "Ny Style sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara sauce";

        toppings.add("Grated Reggiano Cheese");
    }
}
