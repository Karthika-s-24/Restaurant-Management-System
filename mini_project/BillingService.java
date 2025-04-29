package Service;
import Model.Order;

public class BillingService {
	public void Bill(Order order) {
		System.out.println("     BILL ");
		System.out.println();
		order.Items().forEach(item-> {
			System.out.println(item.Dish() + " - Rs " + item.Price());
		});
		double total = order.Total();
		double tax = total*0.1;
		double finalAmount = total + tax;
		System.out.println("Subtotal : Rs " + total);
		System.out.println("Tax(10%) : Rs " + tax);
		System.out.println("Total : Rs " + finalAmount);
	}
}
