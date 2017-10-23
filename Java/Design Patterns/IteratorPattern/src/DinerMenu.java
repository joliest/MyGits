import java.util.*;

public class DinerMenu implements Menu {
	
	MenuItem[] menuItems;
	int numberOfItems = 0;
	static final int MAX_ITEMS = 6;
	
	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];
		

		addItem("Vegetarian BLT",
				"(Fakin') Bacon with lettuce & tomato on whole wheat ", true, 2.99);
		
		addItem("BLT", 
				"Bacon with lettuce & tomato on whole wheat", false, 2.99);
		
		addItem("Soup of the day", 
				"Soup of the day with a side potato salad",	false, 3.29);
		
		addItem("Hotdog",
				"A hotdog, with saurkaut, relish, onions, topped with cheese",
				false, 3.05);
	}
	
	public void addItem(String name, 
						String description,
						boolean vegetarian,
						double price) {
		
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems[numberOfItems] = menuItem;
		numberOfItems += 1;
	}

	@Override
	public Iterator createIterator() {
		Iterator iterator = new DinerMenuIterator(menuItems);
		return iterator;
	}

}
