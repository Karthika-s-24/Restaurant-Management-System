package Service;
import Model.MenuItem;
import Model.Order;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderService {
	private List<Order> orderList = new ArrayList<>();
	public void placeOrder(int TableNumber, List<MenuItem> items) {
		orderList.add(new Order(TableNumber, items));
		System.out.println(TableNumber + " Table - Order Placed");
	}
	public OrderService() {
		MenuItem b = new MenuItem("Dosa", 130, "Mains");
		MenuItem c = new MenuItem("Coffee", 25, "Drinks");
		Order o1 = new Order(1, Arrays.asList(b, c));
		orderList.add(o1);
	}
	public void PlaceOrder(int TableNumber, List<MenuItem> items) {
		orderList.add(new Order(TableNumber, items));
		System.out.println(TableNumber + " Table - Order Placed");
	}
	public void View() {
		System.out.println(" CURRENT ORDERS ");
		System.out.println();
		if(orderList.isEmpty()) {
			System.out.println("No Orders.");
			return;
		}
		for(Order order : orderList) {
			System.out.println("Table : " + order.TableNo());
			System.out.println("Items : ");
			for(MenuItem item : order.Items()) {
				System.out.println(" - " + item);
			}
			System.out.println("Status : " + order.Status());
			System.out.println();
		}
	}
	public List<Order> getOrderList() {
		return orderList;
	}
}
