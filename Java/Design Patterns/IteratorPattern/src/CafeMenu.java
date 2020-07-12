import java.util.Hashtable;
import java.util.Iterator;

public class CafeMenu implements Menu{
	
	//or.. use newer HashMap
	Hashtable menuItems;
	
	public CafeMenu() {
		menuItems = new Hashtable();
		

		addItem("Veggie Burger and Air Fries", 
				"Veggie Burger on a whole wheat bun, lettuce, tomato and fries",
				false, 3.69);
		
		addItem("Soup of the day",
				"A cup of the soup of the dat, with a side salad",
				false, 3.69);
		
		addItem("Burrito",
				"A large burrito, with whole pinto beans, salsa, guacamole",
				true, 4.29);
	}
	
	public void addItem(String name, 
						String description,
						boolean vegetarian,
						double price) {
		
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.put(menuItem.getName(), menuItem);
	}

	@Override
	public Iterator createIterator() {
		//this how user returns iterator from Hashtables
		return menuItems.values().iterator();
	}

}
