import java.util.ArrayList;

public class Tester {
	public static void main(String[] args) {
		MenuComponent  pancakeHouseMenu = 
				new Menu("PANCAKE HOUSE MENU", "Breakfast");
		pancakeHouseMenu.add(new MenuItem("K&B's Pancake Breakfast",
				"Pancake with scrambled eggs, and toast",
				true,
				2.99)
		);
		
		pancakeHouseMenu.add(new MenuItem("Regular Pancake Breakfast",
				"Pancake with fried eggs, sausage",
				false,
				2.99)
		);
		
		pancakeHouseMenu.add(new MenuItem("Blueberry Pancakes",
				"Pancakes made with fresh blueberries",
				true,
				3.49)
		);
		
		pancakeHouseMenu.add(new MenuItem("Waffles", 
				"Waffles, with your choice of blueberries or strawberries",
				true,
				3.49)
		);
		
		MenuComponent dinerMenu = 
				new Menu("DINER MENU", "Lunch");
		dinerMenu.add(new MenuItem("Vegetarian BLT",
				"(Fakin') Bacon with lettuce & tomato on whole wheat ", true, 2.99));
		dinerMenu.add(new MenuItem("BLT", 
				"Bacon with lettuce & tomato on whole wheat", false, 2.99));
		dinerMenu.add(new MenuItem("Soup of the day", 
				"Soup of the day with a side potato salad",	false, 3.29));
		dinerMenu.add(new MenuItem("Hotdog",
				"A hotdog, with saurkaut, relish, onions, topped with cheese",
				false, 3.05));
		
		MenuComponent cafeMenu = 
				new Menu("CAFE MENU", "Dinner");
		cafeMenu.add(new MenuItem("Veggie Burger and Air Fries", 
				"Veggie Burger on a whole wheat bun, lettuce, tomato and fries",
				false, 3.69));
		cafeMenu.add(new MenuItem("Soup of the day",
				"A cup of the soup of the dat, with a side salad",
				false, 3.69));
		cafeMenu.add(new MenuItem("Burrito",
				"A large burrito, with whole pinto beans, salsa, guacamole",
				true, 4.29));
				
		MenuComponent dessertMenu =
				new Menu("DESSERT MENU", "Dessert of course");		
		
		MenuComponent allMenus = 
				new Menu("ALL MENUS", "All Menus Combined");
		allMenus.add(pancakeHouseMenu);
		allMenus.add(dinerMenu);
		allMenus.add(cafeMenu);
		
		dinerMenu.add(new MenuItem(
				"Pasta", 
				"Sphagetti with Marinara Sauce, and a slice of sourdough",
				true, 3.90));
		
		dessertMenu.add(new MenuItem(
				"Apple Pie", 
				"Apple Pie with flakey crust, topped with vanilla icecream", 
				true, 
				1.59));
		
		cafeMenu.add(dessertMenu);
		
		Waitress waitress = new Waitress(allMenus);
		waitress.printMenu();
	}
}
