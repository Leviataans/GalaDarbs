import java.util.ArrayList;
import java.util.List;

public class UserDetails {

    private int id = 0;
    private List<User> users = new ArrayList<>();

    public UserDetails() {
        users = new ArrayList<>();
    }
    
    public UserDetails(List<User> users) {
		this.users = users;
	}

    public boolean isRegistredUser(String email) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean signUp(String eMail, String firstName, String lastName) {
        User user = new User();
        int id = users.size()+1;
        user.setEmail(eMail);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setId(id);
        users.add(user);
        return true;
    }

    public int logIn(String eMail) {
        for (User user : users) {
            if (user.getEmail().equals(eMail)) {
                //Check if we have all the necessary data about him
                if (user.getFirstName() == null) {
                    //firstLogInUpdate(user);
                }
                return user.getId();
            }
        }
        return 0;
    }

    public void updateUser(int id, String firstName, String lastName, String city, String address, int phoneNumber) {
        User user = users.get(id-1);
        user.setEmail(user.getEmail());
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setCity(city);
        user.setStreet(address);
        user.setPhoneNumber(phoneNumber);
        //users.indexOf(user.getId()).
    }

    public void deleteUser(int id) {
        users.remove(id-1);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "users=" + users +
                '}';
    }
}
