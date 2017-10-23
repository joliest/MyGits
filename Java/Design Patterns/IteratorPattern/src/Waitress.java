
import java.util.*;

public class Waitress {
	Menu pancakeMenu;
	Menu dinerMenu;
	Menu cafeMenu;
	
	public Waitress(Menu pancakeMenu, Menu dinerMenu, Menu cafeMenu) {
		this.pancakeMenu = pancakeMenu;
		this.dinerMenu = dinerMenu;
		this.cafeMenu = cafeMenu;
	}
	
	public void printMenu() {
		Iterator pancakeMenuIterator = pancakeMenu.createIterator();
		Iterator dinerMenuIterator = dinerMenu.createIterator();
		Iterator cafeMenuIterator = cafeMenu.createIterator();
		
		System.out.println("Breakfast: ");
		printMenu(pancakeMenuIterator);
		
		System.out.println("Lunch: ");
		printMenu(dinerMenuIterator);
		
		System.out.println("Dinner: ");
		printMenu(cafeMenuIterator);
	}
	
	public void printMenu(Iterator iterator) {
		while(iterator.hasNext()) {
			MenuItem item = (MenuItem) iterator.next();
			System.out.println(item.getName() + ", ");
			System.out.println(item.getDescription() + ", ");
			System.out.println("$ " + item.getPrice());
		}
	}
}
