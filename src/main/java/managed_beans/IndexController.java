package managed_beans;

import dao.DaoContext;
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
        return primes;
    }

    public void setPrimes(List<Prime> primes) {
        this.primes = primes;
    }

    @PostConstruct
    public void init() {
        initDaoContext();
        primeDAO = new PrimeDAO();
        primes = primeDAO.findAll();
    }

    private void initDaoContext() {
        DaoContext.getUserDao();
    }
}
