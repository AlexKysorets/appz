package com.example.appz;

import com.example.appz.models.PurchaseDetail;
import com.example.appz.models.Subscription;
import com.example.appz.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class HibernateUtil {
    static Session session;
    static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            // handle the exception
        }
        return sessionFactory;
    }

    public static void displayTest() {
        User user;
//        session = sessionFactory.openSession();
//        session.beginTransaction();
        session = buildSessionFactory().openSession();
        try {

//            user = session.get(User.class, 1);
//            if(user != null) {
//                System.out.println("\nUser Record?= " + user);
//            } else {
//                System.out.println(user);
//            }
            List<PurchaseDetail> purchaseDetails = session.createQuery("from PurchaseDetail ", PurchaseDetail.class).list();
            purchaseDetails.forEach(System.out::println);
        } catch(Exception sqlException) {
            if(null != session.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }
}
