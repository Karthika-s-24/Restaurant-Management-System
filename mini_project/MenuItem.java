package Model;

public class MenuItem {
	private String dish;
	private double price;
	private String category;
	public MenuItem(String dish, double price, String category) {
		this.dish = dish;
		this.price = price;
		this.category = category;
	}
	public String Dish() {
		return dish;
	}
	public double Price() {
		return price;
	}
	public String Category() {
		return category;
	}
	public String toString() {
		return Dish() + " - Rs " + Price() + " ( " + Category() + " ) ";
	}
}
