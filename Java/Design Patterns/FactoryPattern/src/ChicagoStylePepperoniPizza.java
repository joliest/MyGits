
public class ChicagoStylePepperoniPizza extends Pizza {
	public ChicagoStylePepperoniPizza() {
		name = "Chicago Style Pepperoni Pizza";
		dough = "Extra Thick Crust";
		sauce = "Delmonte Tomato Sauce";
		
		toppings.add("Eastern cheeze");
		toppings.add("Organic cheeze");
	}
	
	public void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
