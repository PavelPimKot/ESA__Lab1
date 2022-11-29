package servlets;

import beans.service.AdminService;
import beans.service.CategoryService;
import beans.service.ClientService;
import entities.Admin;
import entities.Category;
import entities.Client;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/logIn")
public class LogInServlet extends HttpServlet {

    @EJB
    private AdminService adminService;

    @EJB
    private ClientService clientService;

    @EJB
    private CategoryService categoryService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        List<Client> client = new ArrayList<>();
        List<Admin> admin = new ArrayList<>();
        client = clientService.findClientByLoginAndPassword(login, password);
        admin = adminService.findAdminByLoginAndPassword(login, password);
        List<Category> categories = categoryService.getCategories();
        if (!client.isEmpty()) {
            req.getSession().setAttribute("currentUserId", client.get(0).getId());
            req.getSession().setAttribute("categories", categories);
            req.getSession().setAttribute("userRole", "Client");
            resp.sendRedirect("main.jsp");
        } else {
            if (!admin.isEmpty()) {
                req.getSession().setAttribute("currentUserId", admin.get(0).getId());
                req.getSession().setAttribute("categories", categories);
                req.getSession().setAttribute("userRole", "Admin");
                resp.sendRedirect("main.jsp");
            } else {
                req.getSession().setAttribute("errorMessage", "Пользователя с таким логином  и паролем не существует");
                resp.sendRedirect("error.jsp");
            }
        }
    }
}