package databaseHibernate;

import Entities.Credential;
import Entities.User;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public interface UserDao {

     void saveUser(User user, Logger logger);

     boolean saveCredential(Credential credential, Logger logger);

     Optional<Credential> retrieveCredential(String email, Logger logger);



     String retrieveUserUsingEmail(String email,Logger logger);
}
