package orders;

import customers.CustomerNotifier;
import pizzas.Pizza;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Pizza pizza;
    private List<CustomerNotifier> observers;

    public Order(Pizza pizza) {
        this.pizza = pizza;
        this.observers = new ArrayList<>();
    }

    public void addObserver(CustomerNotifier observer) {
        observers.add(observer);
    }

    public void removeObserver(CustomerNotifier observer) {
        observers.remove(observer);
    }

    public List<CustomerNotifier> getObservers() {
        return observers;
    }

    public void prepareOrder() {
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        notifyObservers();
    }

    private void notifyObservers() {
        for (CustomerNotifier observer : observers) {
            observer.update(this);
        }
    }

    public Pizza getPizza() {
        return pizza;
    }
}

interface CustomerNotifier {
    void update(Order order);
}
