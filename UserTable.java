import java.util.ArrayList;
import java.util.List;

public class UserTable {
	private List<User> users = new ArrayList<>();

	public UserTable() {
	}

	public UserTable(List<User> users) {
		this.users = users;
	}

	public final List<User> getUsers() {
		return users;
	}

	public final void setUsers(List<User> users) {
		this.users = users;
	}

	public void add(User user) {
		users.add(user);
	}

	@Override
	public String toString() {
		String s = "UserTable\n";
		for (int i = 0; i < users.size(); i++) {
			s += users.get(i) + "\n";
		}
		return s;
	}

	public int getSize() {
		return users.size();
	}

	public int logIn(String email) {
		User result = users.stream().filter(users -> email.equals(users.getEmail())).findFirst().orElse(null);
		if (result != null) {
			System.out.println("Welcome back!");
			return result.getId();
		}
		System.out.println("This email isn't registered in this system!");
		return 0;
	}

	public void updateUser(int id, String email, String firstName, String lastName, String city, String address,
			int phoneNumber) {
		User user = users.get(id - 1);
		user.setEmail(user.getEmail());
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setCity(city);
		user.setStreet(address);
		user.setPhoneNumber(phoneNumber);
		// users.indexOf(user.getId()).
	}

	public void deleteUser(int id) {
		users.remove(id - 1);
	}

}
