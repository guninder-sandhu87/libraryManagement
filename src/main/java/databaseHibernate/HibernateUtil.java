package databaseHibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Optional;

public class HibernateUtil {

    public static Optional<SessionFactory> getConnection(){

        try (var standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build()) {
            var metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
            var sessionFactory = metadata.buildSessionFactory();
            return Optional.ofNullable(sessionFactory);
        }
    }
}
