
public class Tester {
	public static void main(String[] args) {
		Menu breakfast = new PancakeHouseMenu();
		Menu lunch = new DinerMenu();
		
		Waitress waitress = new Waitress(breakfast, lunch);
		waitress.printMenu();
	}
}
