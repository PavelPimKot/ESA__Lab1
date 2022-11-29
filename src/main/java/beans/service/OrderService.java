package beans.service;

import entities.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrdersForAdmin();

    List<Order> getOrdersForClient(Integer clientId);

    List<Order> getOrdersByUserId(Integer userId);

    Order findOrderById(Integer orderId);

    void save(Order order);
}
