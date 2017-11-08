package dao;

import entities.Prime;

import java.util.List;

/**
 *
 * @author arash
 */
public class PrimeDAO extends BaseDAO {

    private static final String CLASS_NAME = "Prime";

    public void create(Prime prime) {
        super.create(prime);
    }

    public List<Prime> findAll() {
        return (List<Prime>) super.findAll(CLASS_NAME);
    }
}
