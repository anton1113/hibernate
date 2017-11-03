package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author arash
 */
public class DaoContext {

    private static final SessionFactory sf;

    private static final PrimeDAO primeDao;
    private static final UserDAO userDao;

    static {

        primeDao = new PrimeDAO();
        userDao = new UserDAO();

        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            sf = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return sf.openSession();
    }

    public static PrimeDAO getPrimeDao() {
        if (primeDao == null) {
            return new PrimeDAO();
        } else {
            return primeDao;
        }
    }

    public static UserDAO getUserDao() {
        if (userDao == null) {
            return new UserDAO();
        } else {
            return userDao;
        }
    }
}
