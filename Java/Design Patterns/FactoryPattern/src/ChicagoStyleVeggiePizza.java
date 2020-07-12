
public class ChicagoStyleVeggiePizza extends Pizza {
	public ChicagoStyleVeggiePizza() {
		name = "Chicago Style Veggie Pizza";
		dough = "Extra Thick Crust";
		sauce = "Delmonte Tomato Sauce";
		
		toppings.add("Organic cheeze");
	}
	
	public void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
