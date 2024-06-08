package databaseHibernate;

import Entities.Credential;
import Entities.User;


import jakarta.persistence.TypedQuery;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;

    public void saveUser(User user, Logger logger) {
        if (HibernateUtil.getConnection().isPresent()) {
            sessionFactory = HibernateUtil.getConnection().get();

            try {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                session.persist(user);
                transaction.commit();
                logger.info("User persisted successfully");
            } catch (ConstraintViolationException e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                System.out.println("exception" + e.getMessage());
                logger.error("Failed to persist user", e);
            } finally {
                if (session != null) {
                    session.close();
                }
            }
        } else {
            logger.warn("No connection available");
        }
    }

    public boolean saveCredential(Credential credential, Logger logger) {
        boolean userCreated = false;

        if (HibernateUtil.getConnection().isPresent()) {
            sessionFactory = HibernateUtil.getConnection().get();


            try {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                session.persist(credential);
                transaction.commit();
                logger.info("User persisted successfully");
                userCreated = true;
            } catch (ConstraintViolationException e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                System.out.println("exception" + e.getMessage());
                logger.error("Failed to persist user", e);
            } finally {
                if (session != null) {
                    session.close();
                }
            }
        } else {
            logger.warn("No connection available");
        }

        return userCreated;
    }

    @Override
    public Optional<Credential> retrieveCredential(String email, Logger logger) {
        Credential credential = null;
        if (HibernateUtil.getConnection().isPresent()) {
            sessionFactory = HibernateUtil.getConnection().get();
            try {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                credential = session.get(Credential.class, email);
                transaction.commit();

            } catch (HibernateException e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                logger.error("Unable to retrieve the credential");
            } finally {
                if (session != null) {
                    session.close();
                }
            }


        }
        return Optional.ofNullable(credential);
    }

    @Override
    public String retrieveUserUsingEmail(String email, Logger logger) {
        String userName = null;
        if (HibernateUtil.getConnection().isPresent()) {
            sessionFactory = HibernateUtil.getConnection().get();
            try {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                String query = "Select u.name FROM User AS u WHERE u.email = :email";
                TypedQuery<String> userQuery = session.createQuery(query, String.class);
                userQuery.setParameter("email", email);
                userName = userQuery.getSingleResult();

            } catch (HibernateException e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                logger.error("Unable to retrieve the element");
            } finally {
                if (session != null) {
                    session.close();
                }
            }

        }
        return userName;
    }
}
