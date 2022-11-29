package servlets;

import beans.service.ElementService;
import beans.service.OrderService;
import entities.Element;
import entities.Order;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/offerOrder")
public class OfferOrderServlet extends HttpServlet {

    @EJB
    private ElementService elementService;

    @EJB
    private OrderService orderService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = orderService.findOrderById((Integer) req.getSession().getAttribute("currentOrderId"));
        int totalCost = 0;
        for (Element element : order.getElements()) {
            element.setCount(Integer.parseInt(req.getParameter(element.getCode().toString())));
            totalCost += element.getCount() * element.getProduct().getPrice();
            elementService.save(element);
        }
        order.setStatus("Accepted");
        order.setCost(totalCost);
        orderService.save(order);
        req.getSession().removeAttribute("currentOrderId");
        resp.sendRedirect("lk_user");
    }
}
