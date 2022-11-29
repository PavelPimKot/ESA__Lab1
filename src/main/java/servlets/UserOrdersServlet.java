package servlets;

import beans.service.OrderService;
import entities.Order;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/my_orders")
public class UserOrdersServlet extends HttpServlet {

    @EJB
    private OrderService orderService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Integer clientId = (Integer) req.getSession().getAttribute("currentUserId");
        List<Order> orders = orderService.getOrdersForClient(clientId);
        if (!orders.isEmpty()) {
            orders = orders.stream().filter(order -> !order.getStatus().equals("In Progress")).collect(Collectors.toList());
            req.setAttribute("orders", orders);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("my_orders.jsp");
        requestDispatcher.forward(req, resp);
    }
}