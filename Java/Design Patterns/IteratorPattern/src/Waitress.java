
import java.util.*;

public class Waitress {
	Menu pancakeMenu;
	Menu dinerMenu;
	
	public Waitress(Menu pancakeMenu, Menu dinerMenu) {
		this.pancakeMenu = pancakeMenu;
		this.dinerMenu = dinerMenu;
	}
	
	public void printMenu() {
		Iterator pancakeMenuIterator = pancakeMenu.createIterator();
		Iterator dinerMenuIterator = dinerMenu.createIterator();
		
		System.out.println("Breakfast: ");
		printMenu(pancakeMenuIterator);
		
		System.out.println("Lunch: ");
		printMenu(dinerMenuIterator);
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
