package HQL.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    static {
        if (registry == null) {

            try {
                registry = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources metadataSources = new MetadataSources(registry);
                Metadata metadata = metadataSources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                    System.out.println("Destroying StandardServiceRegistry");
                }
            }
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }


}
