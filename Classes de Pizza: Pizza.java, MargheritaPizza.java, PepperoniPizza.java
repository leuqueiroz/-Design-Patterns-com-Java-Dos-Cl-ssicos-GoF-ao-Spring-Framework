package pizzas;

public abstract class Pizza {
    protected String name;
    protected String dough;
    protected String sauce;
    protected String[] toppings;

    public String getName() {
        return name;
    }

    public void prepare() {
        System.out.println("Preparing " + name);
    }

    public void bake() {
        System.out.println("Baking " + name);
    }

    public void cut() {
        System.out.println("Cutting " + name);
    }

    public void box() {
        System.out.println("Boxing " + name);
    }
}

class MargheritaPizza extends Pizza {
    public MargheritaPizza() {
        name = "Margherita Pizza";
        dough = "Thin crust";
        sauce = "Tomato sauce";
        toppings = new String[]{"Mozzarella cheese", "Basil"};
    }
}

class PepperoniPizza extends Pizza {
    public PepperoniPizza() {
        name = "Pepperoni Pizza";
        dough = "Regular crust";
        sauce = "Marinara sauce";
        toppings = new String[]{"Pepperoni", "Cheese"};
    }
}
