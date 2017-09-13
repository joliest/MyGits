
public class PizzaDriveTester {
	public static void main(String[] args) {
		NYPizzaStore nyPizzaStore = new NYPizzaStore();
		nyPizzaStore.orderPizza("Cheese");
		
		ChicagoPizzaStore chPizzaStore = new ChicagoPizzaStore();
		chPizzaStore.orderPizza("clam");
	}
}
