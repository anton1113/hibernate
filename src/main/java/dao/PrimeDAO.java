package dao;

import entities.Prime;

import java.util.List;

/**
 *
 * @author arash
 */
public class PrimeDAO extends BaseDAO {

    public List<Prime> findAll() {
        return (List<Prime>) super.findAll();
    }
}
