
public class ChicagoStyleClamPizza extends Pizza {
	public ChicagoStyleClamPizza() {
		name = "Chicago Style Clam Pizza";
		dough = "Extra Thick Crust";
		sauce = "Delmonte Tomato Sauce";
		
		toppings.add("Swedish cheeze");
	}
	
	public void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
