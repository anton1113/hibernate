package managed_beans;

import dao.PrimeDAO;
import entities.Prime;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "index")
@ViewScoped
public class IndexController {

    private PrimeDAO primeDAO;

    private List<Prime> primes;

    public List<Prime> getPrimes() {
        return primeDAO.findAll();
    }

    public void setPrimes(List<Prime> primes) {
        this.primes = primes;
    }

    @PostConstruct
    public void init() {
        primeDAO = new PrimeDAO();
    }

    public void onCreatePrimeCommandButtonClicked() {
        addNewPrime();
    }

    public void onDeleteAllPrimesCommandButtonClicked() {
        deleteAllPrimes();
    }

    private void addNewPrime() {
        primeDAO.create(new Prime());
    }

    private void deleteAllPrimes() {
        primeDAO.deleteAll();
    }
}
