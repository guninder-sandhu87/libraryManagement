package servlet;

import Entities.Employee;
import databaseHibernate.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "registerServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        var name = req.getParameter("name");
        var email = req.getParameter("email");
        var phone = req.getParameter("phone");
        var password = req.getParameter("phone");
    }

    private void saveUser(Employee employee) {
        if (HibernateUtil.getConnection().isPresent()) {
            var sessionFactory = HibernateUtil.getConnection().get();
            var session = sessionFactory.openSession();
            var transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        }


    }
}
