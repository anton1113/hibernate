package dao;

import org.hibernate.Session;

/**
 *
 * @author arash
 */
public abstract class BaseDAO {

    protected void create(Object object) {

        try {
            Session session = DaoContext.getSession();
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
