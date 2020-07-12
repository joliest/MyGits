
public class ClamPizza extends Pizza{
	PizzaIngredientFactory ingredientFactory;
	
	public ClamPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	public void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		//the cheese factory doesnt have createClam() method
		clam = ingredientFactory.createClam();
		
		System.out.println("Tossing " + dough + " ...");
		System.out.println("Adding " + sauce + " ...");
		System.out.println("Adding " + cheese + " ...");
		System.out.println("Adding " + clam + " ...");
	}
	
}
