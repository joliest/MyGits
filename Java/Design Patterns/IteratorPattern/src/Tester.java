
public class Tester {
	public static void main(String[] args) {
		Menu breakfast = new PancakeHouseMenu();
		Menu lunch = new DinerMenu();
		Menu dinner = new CafeMenu();
		
		Waitress waitress = new Waitress(breakfast, lunch, dinner);
		waitress.printMenu();
	}
}
