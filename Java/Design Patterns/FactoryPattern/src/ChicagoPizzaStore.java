
public class ChicagoPizzaStore extends PizzaStore{
	public Pizza createPizza(String type) {
		Pizza pizza;
		if(type.equals("Cheese")) {
			pizza = new ChicagoStyleCheezePizza();
		} else if(type.equals("pepperoni")) {
			pizza = new ChicagoStylePepperoniPizza();
		} else if(type.equals("clam")) {
			pizza = new ChicagoStyleClamPizza();
		} else if(type.equals("veggie")) {
			pizza = new ChicagoStyleVeggiePizza();
		} else {
			System.out.println("Pizza type isn't valid");
			pizza = null;
		}
		return pizza;
	}
	
}
