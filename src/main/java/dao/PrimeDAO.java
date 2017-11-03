package dao;

import entities.Prime;
import org.hibernate.Session;

/**
 *
 * @author arash
 */
public class PrimeDAO extends BaseDAO {

    public void create(Prime prime) {

        Session session = getSession();
        session.beginTransaction();
        session.save(prime);
        session.getTransaction().commit();
        session.close();
    }
}
