package servlets;

import beans.service.ClientService;
import beans.service.ElementService;
import beans.service.OrderService;
import beans.service.ProductService;
import entities.Client;
import entities.Element;
import entities.Order;
import entities.Product;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@WebServlet("/buy_item")
public class BuyItemServlet extends HttpServlet {
    @EJB
    private ProductService productService;

    @EJB
    private ClientService clientService;

    @EJB
    private OrderService orderService;

    @EJB
    private ElementService elementService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("productId"));
        Integer currentUserId = (Integer) req.getSession().getAttribute("currentUserId");
        Client client = clientService.getClient(currentUserId);
        List<Order> orderList = orderService.getOrdersByUserId(currentUserId);
        Optional<Order> currOrder = orderList.stream().filter(order -> order.getStatus().equals("In Progress")).findFirst();
        Product product = productService.findProductById(id);
        if (currOrder.isPresent()) {
            Order order = currOrder.get();
            Element element = new Element();
            element.setCount(1);
            element.setOrder(order);
            element.setProduct(product);
            req.getSession().setAttribute("currentOrderId", order.getId());
            elementService.save(element);
        } else {
            Order order = new Order();
            order.setClient(client);
            order.setStatus("In Progress");
            order.setCost(0);
            order.setOrderDate(new Date());
            order.setDeliveryDate(new Date());
            orderService.save(order);
            req.getSession().setAttribute("currentOrderId", order.getId());
            Element element = new Element();
            element.setCount(1);
            element.setOrder(order);
            element.setProduct(product);
            elementService.persist(element);
        }
        resp.sendRedirect("items");
    }
}
