package beans.repository.impl;

import beans.repository.OrderRepository;
import entities.Order;

import javax.ejb.Singleton;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
@Transactional
public class OrderRepositoryImpl extends AbstractRepository implements OrderRepository {
    @Override
    public List<Order> getOrdersForAdmin() {
        return entityManager.createQuery(
                "select order from Order order where   order.isDeleted = false ", Order.class).getResultList();
    }

    @Override
    public List<Order> getOrdersForClient(Integer clientId) {
        return entityManager.createQuery(
                "select order from Order order where order.client.id = :id and order.isDeleted = false ",
                Order.class).setParameter("id", clientId).getResultList();
    }

    @Override
    public List<Order> getOrdersByUserId(Integer userId) {
        return entityManager.createQuery(
                "select order from Order order where order.client.id = :id and order.isDeleted = false ",
                Order.class).setParameter("id", userId).getResultList();
    }

    @Override
    public Order findOrderById(Integer orderId) {
        return entityManager.find(Order.class, orderId);
    }
}
