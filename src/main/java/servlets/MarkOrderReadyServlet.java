package servlets;

import beans.service.OrderService;
import entities.Order;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/markOrderReady")
public class MarkOrderReadyServlet extends HttpServlet {

    @EJB
    private OrderService orderService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = orderService.findOrderById(Integer.parseInt(req.getParameter("orderId")));
        order.setStatus("Issued");
        orderService.save(order);
        resp.sendRedirect("main.jsp");
    }
}
