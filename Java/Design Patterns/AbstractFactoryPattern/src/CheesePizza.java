
public class CheesePizza extends Pizza{
	
	private PizzaIngredientFactory ingredientFactory;
	
	public CheesePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
	
	@Override
	public void prepare() {
		System.out.println("Preparing " + name);
		//this is where magic happens
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		
		System.out.println("Tossing " + dough + " ...");
		System.out.println("Adding " + sauce + " ...");
		System.out.println("Adding " + cheese + " ...");
	}

}
