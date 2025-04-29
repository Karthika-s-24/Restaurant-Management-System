package Service;
import Model.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class MenuService {
	private List<MenuItem> menuList = new ArrayList<>();
	public MenuService() {
		menuList.add(new MenuItem("Dosa", 130, "Mains"));
		menuList.add(new MenuItem("Idli", 100, "Mains"));
		menuList.add(new MenuItem("Tea", 25, "Drinks"));
		menuList.add(new MenuItem("Coffee", 25, "Drinks"));
		menuList.add(new MenuItem("Kesari", 80, "Desserts"));
		menuList.add(new MenuItem("Gulab Jamun", 90, "Desserts"));
	}
	public void Add(MenuItem item) {
		menuList.add(item);
		System.out.println("Item Added.");
	}
	public void View() {
		System.out.println("MENU");
		System.out.println();
		if(menuList.isEmpty()) {
			System.out.println("Items are Unavailable");
		}
		else {
			for(int i=0;i<menuList.size();i++) {
				MenuItem item = menuList.get(i);
				System.out.println((i+1) + ". " + item.Dish() + " - Rs " + item.Price() + " ( " + item.Category() + " ) ");
			}
		}
	}
	public List<MenuItem> getMenuList() {
		return menuList;
	}
}
