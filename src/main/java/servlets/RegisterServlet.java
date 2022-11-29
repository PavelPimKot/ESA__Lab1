package servlets;

import beans.service.CategoryService;
import beans.service.ClientService;
import entities.Category;
import entities.Client;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @EJB
    private CategoryService categoryService;

    @EJB
    private ClientService clientService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();

        Client client = new Client();

        client.setFirstName(req.getParameter("user_name"));
        client.setLastName(req.getParameter("user_lastname"));
        client.setMiddleName(req.getParameter("user_secondname"));
        client.setPassword(req.getParameter("user_pass"));
        client.setPhone(req.getParameter("user_phone"));
        client.setAddress(req.getParameter("user_adr"));
        client.setLogin(req.getParameter("user_login"));
        client.setEmail(req.getParameter("user_mail"));
        try {
            Date user_birthday = new SimpleDateFormat("dd.MM.yyyy").parse(req.getParameter("user_birthday"));
            client.setBirthDay(user_birthday);
        } catch (ParseException e) {
            req.getSession().setAttribute("errorMessage", "Некорректный формат даты");
            resp.sendRedirect("src/error.jsp");
            return;
        }
        clientService.save(client);


        List<Category> categories = categoryService.getCategories();
        req.getSession().setAttribute("categories", categories);
        req.getSession().setAttribute("userRole", "Client");
        req.getSession().setAttribute("currentUserId", client.getId());
        resp.sendRedirect("main.jsp");
    }
}
