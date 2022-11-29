package servlets;

import beans.repository.OrderRepository;
import dto.ShoppingCardElementRecord;
import entities.Element;
import entities.Order;
import entities.Product;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/lk_user")
public class LkUserServlet extends HttpServlet {

    @EJB
    private OrderRepository orderRepository;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Integer orderId = (Integer) req.getSession().getAttribute("currentOrderId");
        if (orderId != null) {
            Order currentOrder = orderRepository.findOrderById(orderId);
            List<ShoppingCardElementRecord> records = new ArrayList<>();

            for (Element element : currentOrder.getElements()) {
                ShoppingCardElementRecord record = new ShoppingCardElementRecord();
                Product product = element.getProduct();
                record.setCost(product.getPrice());
                record.setElementId(element.getCode());
                record.setName(product.getName());
                record.setPictureUrl(product.getPicture());
                record.setProductId(product.getId());
                records.add(record);
            }

            req.setAttribute("shoppingCardList", records);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("lk_user.jsp");
        requestDispatcher.forward(req, resp);
    }
}