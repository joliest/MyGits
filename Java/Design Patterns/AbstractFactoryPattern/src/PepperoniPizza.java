
public class PepperoniPizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
	
	public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	public void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		pepperoni = ingredientFactory.createPepperoni();
		
		System.out.println("Tossing " + dough + " ...");
		System.out.println("Adding " + sauce + " ...");
		System.out.println("Adding " + cheese + " ...");
		System.out.println("Adding " + pepperoni + " ...");
	}
}
