package servlet;

import Entities.Credential;
import Entities.Employee;
import Entities.User;
import databaseHibernate.HibernateUtil;
import databaseHibernate.UserDao;
import databaseHibernate.UserDaoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.ConstraintViolationException;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet(name = "registerServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var name = req.getParameter("name");
        var email = req.getParameter("email");
        var phone = Integer.parseInt(req.getParameter("phone"));
        var password = req.getParameter("password");
        UserDao userDao = new UserDaoImpl();
        User user = new User(name, email, phone);
        userDao.saveUser(user, logger);
        Credential credential = new Credential(email, password);
        if(userDao.saveCredential(credential,logger)){
            var requestDispatcher = req.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(req, resp);
        }
        else{
            var requestDispatcher = req.getRequestDispatcher("/registration.jsp");
            req.setAttribute("user_false","Email is already registered");
            requestDispatcher.forward(req, resp);
        }

        logger.info("New user created with email {}", email);
    }


}