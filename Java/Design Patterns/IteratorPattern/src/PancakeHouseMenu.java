import java.util.*;

public class PancakeHouseMenu implements Menu{
	
	ArrayList menuItems;
	
	public PancakeHouseMenu() {
		menuItems = new ArrayList();
		
		addItem("K&B's Pancake Breakfast",
				"Pancake with scrambled eggs, and toast",
				true,
				2.99);
		
		addItem("Regular Pancake Breakfast",
				"Pancake with fried eggs, sausage",
				false,
				2.99);
		
		addItem("Blueberry Pancakes",
				"Pancakes made with fresh blueberries",
				true,
				3.49);
		
		addItem("Waffles", 
				"Waffles, with your choice of blueberries or strawberries",
				true,
				3.49);
	}
	
	public void addItem(String name, String description,
						boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}
	
	@Override
	public Iterator createIterator() {
		Iterator itemsIterator = menuItems.iterator();
		return itemsIterator;
	}
	
	public ArrayList getMenuItems() {
		return menuItems;
	}

}
