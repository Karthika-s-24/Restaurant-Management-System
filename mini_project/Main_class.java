package Main;
import Model.*;
import Service.*;
import java.util.*;

public class Main_class {
	private static final Scanner a = new Scanner(System.in);
	private static final MenuService menuService = new MenuService();
	private static final OrderService orderService = new OrderService();
	private static final BillingService billingService = new BillingService();
	public static void main(String[] args) {
		System.out.println("     The Masala Pavilion ");
		System.out.println();
		System.out.println("Username : ");
		String username = a.nextLine();
		System.out.println();
		System.out.println("Role (Admin/Waiter/Chef/Cashier) : ");
		String role = a.nextLine();
		User user = new User(username, role);
		switch(user.Role()) {
		case "Admin" -> adminMenu();
		case "Waiter" -> waiterMenu();
		case "Chef" -> chefMenu();
		case "Cashier" -> cashierMenu();
		default -> System.out.println("Error");
		}
	}
	private static void adminMenu() {
		while(true) {
			System.out.println("     Admin Menu ");
			System.out.println();
			System.out.println("1. Add to Menu");
			System.out.println("2. View Menu");
			System.out.println("3. Close");
			System.out.println();
			System.out.print("Option : ");
			int option = a.nextInt();
			a.nextLine();
			switch(option) {
			case 1 -> {
				System.out.println("Dish : ");
				String dish = a.nextLine();
				System.out.println();
				System.out.println("Price : ");
				double price = a.nextDouble();
				a.nextLine();
				System.out.println();
				System.out.println("Category : ");
				String category = a.nextLine();
				System.out.println();
				menuService.Add(new MenuItem(dish, price, category));
				}
			case 2 -> menuService.View();
			case 3 -> {
				System.out.println("Exit from Admin Menu.");
				return;
			}
			default -> System.out.println("Error");
			}
		}
	}
	private static void waiterMenu() {
		while(true) {
			System.out.println("     Waiter Menu ");
			System.out.println();
			System.out.println("1. Place Order");
			System.out.println("2. Close");
			System.out.println();
			System.out.print("Option : ");
			int option = a.nextInt();
			a.nextLine();
			if(option == 1) {
				menuService.View();
				System.out.println();
				System.out.println("Table Number : ");
				int TableNo = a.nextInt();
				System.out.println();
				a.nextLine();
				List<MenuItem> selectedItems = new ArrayList<>();
				while(true) {
					System.out.println("Enter menu item number : ");
					int ItemNo = a.nextInt();
					a.nextLine();
					System.out.println();
					if(ItemNo == 0) break;
					List<MenuItem> menu = menuService.getMenuList();
					if(ItemNo>=1 && ItemNo<=menu.size()) {
						selectedItems.add(menu.get(ItemNo - 1));
					}
					else {
						System.out.println("Error");
					}
				}
				orderService.placeOrder(TableNo,  selectedItems);
				System.out.println("Order placed.");
			}
			else if(option == 2) {
				System.out.println("Exit from Waiter Menu.");
				return;
			}
			else {
				System.out.println("Error");
			}
		}
	}
	private static void chefMenu() {
		orderService.View();
	}
	private static void cashierMenu() {
		List<Order> orders = orderService.getOrderList();
		if(orders.isEmpty()) {
			System.out.println("No Bill.");
			return;
		}
		System.out.println("     Bill ");
		System.out.println();
		for(int i=0;i<orders.size();i++) {
			System.out.println((i+1) + ". Table " + orders.get(i).TableNo());
		}
		System.out.println("Order Number : ");
		int num = a.nextInt();
		System.out.println();
		a.nextLine();
		if(num==0) {
			System.out.println("Exit from Cashier Menu.");
			return;
		}
		if(num>=1 && num<=orders.size()) {
			billingService.Bill(orders.get(num - 1));
		}
		else {
			System.out.println("Error");
		}
	}
}