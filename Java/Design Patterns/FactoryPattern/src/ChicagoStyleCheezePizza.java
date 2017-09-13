
public class ChicagoStyleCheezePizza extends Pizza {

	public ChicagoStyleCheezePizza() {
		name = "Chicago Style Cheese Pizza";
		dough = "Extra Thick Crust";
		sauce = "Delmonte Tomato Sauce";
		
		toppings.add("Melted cheese");
	}
	
	public void cut() {
		System.out.println("Cutting the pizza into square slices");
	}

}
