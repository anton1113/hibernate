import dao.PrimeDAO;
import entities.Prime;

/**
 *
 * @author arash
 */
public class Runner {

    public static void main(String[] args) {
        PrimeDAO primeDAO = new PrimeDAO();

        for (int i = 5; i < 25; i++) {
            Prime prime = new Prime();
            primeDAO.create(prime);
        }
    }
}
