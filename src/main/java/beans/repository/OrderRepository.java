package beans.repository;

import entities.Order;

import java.util.List;

public interface OrderRepository extends Repository {
    List<Order> getOrdersForAdmin();

    List<Order> getOrdersForClient(Integer clientId);

    List<Order> getOrdersByUserId(Integer userId);

    Order findOrderById(Integer orderId);
}
