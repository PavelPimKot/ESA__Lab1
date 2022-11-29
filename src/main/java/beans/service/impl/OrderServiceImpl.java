package beans.service.impl;

import beans.repository.OrderRepository;
import beans.service.OrderService;
import entities.Order;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class OrderServiceImpl implements OrderService {
    @EJB
    private OrderRepository orderRepository;

    @Override
    public List<Order> getOrdersForAdmin() {
        return orderRepository.getOrdersForAdmin();
    }

    @Override
    public List<Order> getOrdersForClient(Integer clientId) {
        return orderRepository.getOrdersForClient(clientId);
    }

    @Override
    public List<Order> getOrdersByUserId(Integer userId) {
        return orderRepository.getOrdersByUserId(userId);
    }

    @Override
    public Order findOrderById(Integer orderId) {
        return orderRepository.findOrderById(orderId);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
