package servlets;

import beans.service.StatisticService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/statistic")
public class StatisticServlet extends HttpServlet {

    @EJB
    private StatisticService statisticService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        statisticService.writeSalesStatisticInFile("C:\\Users\\iraur\\Desktop\\GeekShop\\StatFilesDir", "Statistic.txt");
        resp.sendRedirect("lk_admin");
    }
}
