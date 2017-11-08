package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;

/**
 *
 * @author arash
 */
public abstract class BaseDAO {

    private final String DELETE_ALL_QUERY = "delete from " + getEntityClassname();
    private final String FIND_ALL_QUERY = "select o from " + getEntityClassname() + " o";

    protected EntityManager em = HibernateUtil.getEm();

    protected void create(Object object) {
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Collection<? extends Object> findAll() {
        return executeFetchQuery(FIND_ALL_QUERY);
    }

    protected void deleteAll() {
        executeDmlQuery(DELETE_ALL_QUERY);
    }

    private Collection<? extends Object> executeFetchQuery(String query) {

        Collection<?> result = null;

        try {
            Query q = em.createQuery(query);
            result = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private void executeDmlQuery(String query) {
        try {
            em.getTransaction().begin();
            Query q = em.createQuery(query);
            q.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected String getEntityClassname() {
        String daoClassname = getClass().getSimpleName();
        return daoClassname.replace("DAO", "");
    }
}
