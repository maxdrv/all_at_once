package patterns.simple_factory.pizzas;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

    String name;
    String dough;
    String source;
    List<String> toppings = new ArrayList<>();

    public void prepare(){
        System.out.println("preparing " + name);
        System.out.println("Tossing " + dough);
        System.out.println("Adding toppings: ");
        for (String topping : toppings) {
            System.out.println("    " + topping);
        }
    }

    public void bake(){
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut(){
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box(){
        System.out.println("place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }
}
