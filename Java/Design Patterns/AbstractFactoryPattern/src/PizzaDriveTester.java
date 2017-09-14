
public class PizzaDriveTester {
	public static void main(String[] args) {
		NYPizzaStore nyPizzaStore = new NYPizzaStore();
		nyPizzaStore.orderPizza("Cheese");
		nyPizzaStore.orderPizza("veggie");
		
		ChicagoPizzaStore chPizzaStore = new ChicagoPizzaStore();
		chPizzaStore.orderPizza("clam");
		chPizzaStore.orderPizza("veggie");
	}
}
