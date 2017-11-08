package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 *
 * @author arash
 */
public abstract class BaseDAO {

    Session session;
    Transaction tx;

    protected void create(Object object) {

        try {
            startOperation();
            session.save(object);
            endOperation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected List<? extends Object> findAll(String className) {

        List<Object> result = null;

        try {
            startOperation();
            Query query = session.createQuery("select o from " + className + " o");
            result = query.getResultList();
            endOperation();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private void startOperation() {
        session = DaoContext.getSession();
        tx = session.beginTransaction();
    }

    private void endOperation() {
        tx.commit();
        session.close();
    }
}
