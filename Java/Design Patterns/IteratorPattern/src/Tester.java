import java.util.ArrayList;

public class Tester {
	public static void main(String[] args) {
		Menu breakfast = new PancakeHouseMenu();
		Menu lunch = new DinerMenu();
		Menu dinner = new CafeMenu();
		
		ArrayList menus = new ArrayList();
		menus.add(breakfast);
		menus.add(lunch);
		menus.add(dinner);
		
		Waitress waitress = new Waitress(menus);
		waitress.printMenu();
	}
}
