import pizzas.Pizza;
import pizzas.PizzaFactory;
import orders.Order;
import orders.OrderManager;
import customers.Customer;

public class Main {
    public static void main(String[] args) {
        OrderManager orderManager = OrderManager.getInstance();

        Pizza pizza1 = PizzaFactory.createPizza("margherita");
        Order order1 = new Order(pizza1);
        Customer customer1 = new Customer("John Doe");
        order1.addObserver(customer1);

        Pizza pizza2 = PizzaFactory.createPizza("pepperoni");
        Order order2 = new Order(pizza2);
        Customer customer2 = new Customer("Jane Smith");
        order2.addObserver(customer2);

        orderManager.addOrder(order1);
        order1.prepareOrder();

        orderManager.addOrder(order2);
        order2.prepareOrder();
    }
}
