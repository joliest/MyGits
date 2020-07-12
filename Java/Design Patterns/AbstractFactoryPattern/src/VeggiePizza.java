
public class VeggiePizza extends Pizza {
	
	private PizzaIngredientFactory ingredientFactory;
	
	public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
	
	@Override
	public void prepare() {
		System.out.println("Preparing " + name);
		//this is where magic happens
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		veggies = ingredientFactory.createVeggies();
		
		System.out.println("Tossing " + dough + " ...");
		System.out.println("Adding " + sauce + " ...");
		System.out.println("Toppings:");
		for(int i=0; i < veggies.length; i++) {
			int num = i+1;
			System.out.println(num + ": " + veggies[i]);
		}

	}

}
