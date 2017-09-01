
public class StarBuzz {
	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		beverage = new Mocha(beverage);
		System.out.println("Order : " + beverage.getDescription());
		System.out.println("Price : $" +beverage.cost());
		
		Beverage beverage2 = new DarkRoast();
		System.out.println("Order : " + beverage2.getDescription());
		System.out.println("Price : $" +beverage2.cost());
		
		Beverage beverage3 = new Decaf();
		beverage3 = new Milk(beverage3);
		beverage3 = new Soy(beverage3);
		beverage3 = new Whip(beverage3);
		System.out.println("Order : " + beverage3.getDescription());
		System.out.println("Price : $" +beverage3.cost());
	}
}
