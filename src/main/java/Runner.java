import dao.UserDAO;
import entities.User;

/**
 *
 * @author arash
 */
public class Runner {

    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();
        User user = new User();
        user.setFistName("Anton");
        user.setLastName("Rash");
        user.setPhoneNumber("050-516-93-32");
        userDAO.create(user);
    }
}
