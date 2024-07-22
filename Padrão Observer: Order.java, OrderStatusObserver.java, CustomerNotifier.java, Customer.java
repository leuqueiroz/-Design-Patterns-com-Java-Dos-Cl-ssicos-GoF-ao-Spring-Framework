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

    package customers;

import orders.Order;
import orders.CustomerNotifier;

public class Customer implements CustomerNotifier {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(Order order) {
        System.out.println("Hello " + name + ", your order for " + order.getPizza().getName() + " is ready!");
    }
}

}

interface CustomerNotifier {
    void update(Order order);
}
