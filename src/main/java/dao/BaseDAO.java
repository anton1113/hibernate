package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;

/**
 *
 * @author arash
 */
public abstract class BaseDAO {

    protected EntityManager em = HibernateUtil.getEm();

    protected Collection<? extends Object> findAll() {

        Collection<?> result = null;

        try {
            Query q = em.createQuery("select o from " + getEntityClassname() + " o");
            result = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    protected String getEntityClassname() {
        String daoClassname = getClass().getSimpleName();
        return daoClassname.substring(0, daoClassname.length() - 3);
    }
}
