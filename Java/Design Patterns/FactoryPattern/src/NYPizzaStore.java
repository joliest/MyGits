
public class NYPizzaStore extends PizzaStore{

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza;
		if(type.equals("Cheese")) {
			pizza = new NYStyleCheezePizza();
		} else if(type.equals("pepperoni")) {
			pizza = new NYStylePepperoniPizza();
		} else if(type.equals("clam")) {
			pizza = new NYStyleClamPizza();
		} else if(type.equals("veggie")) {
			pizza = new NYStyleVeggiePizza();
		} else {
			System.out.println("Pizza type isn't valid");
			pizza = null;
		}
		return pizza;
	}
	
}
