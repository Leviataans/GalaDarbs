import java.util.Arrays;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		UserTable userTable = new UserTable();
		OrderTable orderTable = new OrderTable();
		ProductTable productTable = new ProductTable();

		User user1 = new User("robertslange@gmail.com", "Roberts", "Lange", "Rîga", "Juglas iela 21-21", 22106390);
		user1.setId(userTable.getSize() + 1);
		if (userTable.logIn(user1.getEmail()) == 0) {
			userTable.add(user1);
		}
		User user2 = new User("rrrrrrrrrrrrrrrrobertslange@gmail.com", "Roberts", "Lange", "Rîga", "Juglas iela 21-21",
				22106390);
		user2.setId(userTable.getSize() + 1);
		if (userTable.logIn(user2.getEmail()) == 0) {
			userTable.add(user2);
		}

		userTable.updateUser(user2.getId(), user2.getEmail(), "Job4iks", "Faartelis", "Ainaþi", "Vai tevi pið?",
				80001818);
		//userTable.deleteUser(user1.getId());

		System.out.println(Arrays.asList(userTable).toString());
		System.out.println(Arrays.asList(orderTable).toString());
		System.out.println(Arrays.asList(productTable).toString());

		String eMail = user2.getEmail();

		int id = userTable.logIn(eMail);

		ProductTypeTable typeTable = new ProductTypeTable();
		while (true) {
			String type = "";
			while (true) {
				println("---------MAIN MENU");
				for (int i = 0; i < typeTable.size(); i++) {
					println("-          " + typeTable.get(i).toString());
				}
				println("---------------------------");
				println("What's your pleasure");
				type = sc.next();
				if (typeTable.exists(type))
					break;
			}
			String products = "";
			while (true) {
				println("-----------"+type.toUpperCase()+"");
				for (int i = 0; i < productTable.size(); i++) {
					//System.out.println("Type: "+type+"\nproductTable.get(i).getProductType()"+productTable.get(i).getProductType());
					if (productTable.get(i).getProductType().equals(type))
					println("-         " + productTable.get(i).getProductName());
				}
				println("---------------------------");
				println("What kind?");
				products = sc.next();
				if (productTable.existsProduct(products))
					break;
			}
			String size = "";
			while (true) {
				println("-----------"+products.toUpperCase()+"");
				for (int i = 0; i < productTable.size(); i++) {
					//System.out.println("Type: "+type+"\nproductTable.get(i).getProductType()"+productTable.get(i).getProductType());
					if (productTable.get(i).getProductType().equals(type))
					println("-         " + productTable.get(i).getProductSize());
				}
				println("---------------------------");
				println("What size?");
				size = sc.next();
				if (productTable.existsSize(size))
					break;
			}
			orderTable.add(new Order(orderTable.getSize() + 1, id, products, false, size));

			println("Have enaugh?");
			if (sc.nextBoolean())
				break;
		}
		sc.close();
		
		orderTable.checkPlease(id);
	}

	public static void println(String message) {
		System.out.println(message);
	}
}
