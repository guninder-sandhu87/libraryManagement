package servlet;

import Entities.Credential;
import databaseHibernate.UserDao;
import databaseHibernate.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Optional;
@WebServlet(name = "login",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private final UserDao userDao = new UserDaoImpl();
    private final Logger logger = LogManager.getLogger();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         var email = req.getParameter("email");
         var password= req.getParameter("password");

         if(validateUser(email,password)){
             String userName = userDao.retrieveUserUsingEmail(email, logger);
             req.getSession().setAttribute("userName",userName);
             resp.sendRedirect("Welcome.jsp");

         }
         else{
             req.getSession().setAttribute("user_not_logged","Invalid login details");
             resp.sendRedirect("login.jsp");
         }
    }



    private  boolean validateUser(String email, String password) {
        Optional<Credential> credentialOptional = userDao.retrieveCredential(email, logger);
        return credentialOptional.map(credential -> credential.validatePassword(password)).orElse(false);
    }
}
