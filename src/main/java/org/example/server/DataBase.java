//package org.example.server;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.example.entities.*;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.TreeMap;
//
//public class DataBase {
//    private static Session session;
//
//    private static SessionFactory getSessionFactory() throws HibernateException {
//        Configuration configuration = new Configuration();
//        // Add ALL of your entities here. You can also try adding a whole package.
//        configuration.addAnnotatedClass(Item.class);
//
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties())
//                .build();
//
//        return configuration.buildSessionFactory(serviceRegistry);
//    }
//
////    static void intitializeDataBase(){
////        Item tree = new Item("greeny",111,"Tree");
////        Item flower= new Item("Flowery",222,"Flower");
////        Item redFlower= new Item("redFlowery",333,"Flower");
////        Item bigTree=new Item("Biggy",444,"Tree");
////        Item smallTree=new Item("Smally",555,"Tree");
////
////        session.save(tree);
////        session.save(flower);
////        session.save(redFlower);
////        session.save(bigTree);
////        session.save(smallTree);
////
////        session.flush();
////    }
//
//
//    public static void connect() {
//        try {
//            SessionFactory sessionFactory = getSessionFactory();
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            intitializeDataBase();
//            session.getTransaction().commit();
//            session.close();
//        } catch (Exception exception) {
//            if (session != null) {
//                session.getTransaction().rollback();
//            }
//            System.err.println("An error occured, changes have been rolled back.");
//            exception.printStackTrace();
//
//        }
//    }
//
//    public static  List<Item> getAllItems(){
//        SessionFactory sessionFactory = getSessionFactory();
//        session = sessionFactory.openSession();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Item> query = builder.createQuery(Item.class);
//        query.from(Item.class);
//        List<Item> items = session.createQuery(query).getResultList();
//        session.close();
//        return items;
//    }
//
//    public static void updateItem(Item item) {
//        try {
//            SessionFactory sessionFactory = getSessionFactory();
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            System.out.println("in updateItem");
//            System.out.println(item.getName());
//            session.update(item);
//            session.flush();
//            System.out.println("in updateItem 2");
//            session.getTransaction().commit();
//            session.close();
//            System.out.println("in updateItem 3");
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//
//    }
//}
