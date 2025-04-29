package Model;
import java.util.List;

public class Order {
	private int TableNumber;
	private List<MenuItem> items;
	private String status;
	public Order(int TableNumber, List<MenuItem> items) {
		this.TableNumber = TableNumber;
		this.items = items;
		this.status = "Preparing";
	}
	public int TableNo() {
		return TableNumber;
	}
	public List<MenuItem> Items() {
		return items;
	}
	public String Status() {
		return status;
	}
	public double Total() {
		return items.stream().mapToDouble(MenuItem::Price).sum();
	}
}
