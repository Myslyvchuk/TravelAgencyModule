package com.softserve.edu.ita.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static String CONFIG_FILE_LOCATION = "hibernate.cfg.xml";
    private static ThreadLocal<Session> threadLocal;
//    !!! DEPRECATED !!!
//    private static final Configuration cfg = new Configuration();
//    !!! NEW BUILD !!!
    private static final Configuration cfg = new Configuration().configure(CONFIG_FILE_LOCATION);
    private static StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
        applySettings(cfg.getProperties());
    private static SessionFactory sessionFactory;

    public static Session currentSession() throws HibernateException {
        //We need to pull threads every time;
        threadLocal = new ThreadLocal<Session>();
        Session session = threadLocal.get();
        if (session == null) {
            if (sessionFactory == null) {
            try {
//                !!! NEW BUILD !!!
//                cfg.configure(CONFIG_FILE_LOCATION);
                sessionFactory = cfg.buildSessionFactory(builder.build());
            }
            catch (Exception e) {
                System.err.println("%%%% Error Creating SessionFactory %%%%");
                e.printStackTrace();
                }
            }
            // !!! It WILL GO FORWARD !!!
            session = sessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }

    public static void closeSession() throws HibernateException {
        threadLocal  = new ThreadLocal<Session>();
        Session session = threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

    public static void closeFactory() throws HibernateException {

        if (!sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }

    private HibernateUtil() {
    }
}