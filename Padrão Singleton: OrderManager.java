package orders;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private static OrderManager instance;
    private List<Order> orders;

    private OrderManager() {
        orders = new ArrayList<>();
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public void addOrder(Order order) {
        orders.add(order);
        notifyObservers(order);
    }

    private void notifyObservers(Order order) {
        for (CustomerNotifier observer : order.getObservers()) {
            observer.update(order);
        }
    }

    public List<Order> getOrders() {
        return orders;
    }
}
