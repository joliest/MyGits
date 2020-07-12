
import java.util.*;

public class Waitress {
	
	ArrayList menus;
	
	/*
	Menu pancakeMenu;
	Menu dinerMenu;
	Menu cafeMenu;
	*/
	
	public Waitress(ArrayList menus) {
		/*
		this.pancakeMenu = pancakeMenu;
		this.dinerMenu = dinerMenu;
		this.cafeMenu = cafeMenu;
		*/
		
		this.menus = (ArrayList) menus;
	}
	
	public void printMenu() {
		/*
		Iterator pancakeMenuIterator = pancakeMenu.createIterator();
		Iterator dinerMenuIterator = dinerMenu.createIterator();
		Iterator cafeMenuIterator = cafeMenu.createIterator();
		
		
		System.out.println("Breakfast: ");
		printMenu(pancakeMenuIterator);
		
		System.out.println("Lunch: ");
		printMenu(dinerMenuIterator);
		
		System.out.println("Dinner: ");
		printMenu(cafeMenuIterator);
		*/
		
		//compact version
		Iterator menuIterator = menus.iterator();
		while(menuIterator.hasNext()) {
			Menu menu = (Menu) menuIterator.next();
			printMenu(menu.createIterator());
		}		
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
