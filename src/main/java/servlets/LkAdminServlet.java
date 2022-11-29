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

@WebServlet("/lk_admin")
public class LkAdminServlet extends HttpServlet {

    @EJB
    private OrderService orderService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Order> orders = orderService.getOrdersForAdmin();
        orders = orders.stream().filter(order -> order.getStatus().equals("Accepted")).collect(Collectors.toList());
        req.setAttribute("orders", orders);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("lk_admin.jsp");
        requestDispatcher.forward(req, resp);
    }
}
