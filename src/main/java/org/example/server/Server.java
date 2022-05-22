package org.example.server;

import org.example.entities.Item;
import org.example.entities.Message;
import org.example.ocsf.server.AbstractServer;
import org.example.ocsf.server.ConnectionToClient;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Server  extends AbstractServer {
    SessionFactory sessionFactory = getSessionFactory();
    private static Session session;
    public static  List<Item> getAllItems(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Item> query = builder.createQuery(Item.class);
        query.from(Item.class);
        List<Item> data = session.createQuery(query).getResultList();
        return data;
    }

    public static void updateItem(Item item) {
        try {
            System.out.println(item.getPrice());
            item.setPrice(item.getPrice());
            session.update(item);
            session.flush();
            System.out.println("FLush");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    static void intitializeDataBase(){
        Item tree = new Item("greeny",111,"Tree");
        session.save(tree);
        session.flush();
        Item flower= new Item("Flowery",222,"Flower");
        session.save(flower);
        session.flush();
        Item redFlower= new Item("redFlowery",333,"Flower");
        session.save(redFlower);
        session.flush();
        Item bigTree=new Item("Biggy",444,"Tree");
        session.save(bigTree);
        session.flush();
        Item smallTree=new Item("Smally",555,"Tree");
        session.save(smallTree);
        session.flush();
    }
    public static Session getSession() {
        return session;
    }


    private static SessionFactory getSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        // Add ALL of your entities here. You can also try adding a whole package.
        configuration.addAnnotatedClass(Item.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        return configuration.buildSessionFactory(serviceRegistry);
    }



    /**
     * Constructs a new server.
     *
     * @param port the port number on which to listen.
     */
    public Server(int port) {
        super(port);
        SessionFactory sessionFactory = getSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
        intitializeDataBase();
        session.getTransaction().commit();
    }

    @Override
    protected void handleMessageFromClient(Object msg, ConnectionToClient client) throws IOException {
        Message message = (Message) msg;
        System.out.println("Message received");
        switch (message.getMsg()) {
            case Message.getAllItems:
                List<Item> items = getAllItems();
                Message response = new Message(Message.recieveAllItems, items);
                try{
                    client.sendToClient(response);

                } catch(IOException e) {
                    e.printStackTrace();
                }
                session.close(); // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ DELETE WHEN ERROR @@@@@@@@@@@@@@@@@
                break;

            case Message.updateItem:
                session = sessionFactory.openSession();
                session.beginTransaction();
                Item item = (Item)message.getObject();
                System.out.println(item.getName());
                updateItem(item);
                session.getTransaction().commit();
                items = getAllItems();
                Message response1 = new Message(Message.recieveAllItems, items);
                client.sendToClient(response1);
                session.close();
                break;


        }
    }
}
