import Ingredients.*;

public interface PizzaIngredientFactory {
/*
 * This is the factory that will create the ingredients.
 * It will be responsible for creating each ingredient in the ingredient family
 */
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
}
