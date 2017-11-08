package dao;

import entities.Prime;

import java.util.List;

/**
 *
 * @author arash
 */
public class PrimeDAO extends BaseDAO {

    public void create(Prime prime) {
        super.create(prime);
    }

    public List<Prime> findAll() {
        return (List<Prime>) super.findAll(getClass().getSimpleName());
    }
}
