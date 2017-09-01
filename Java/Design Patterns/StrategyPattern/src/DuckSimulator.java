
public class DuckSimulator {
	public static void main(String[] args) {
		Duck donald = new MallardDuck();
		donald.setFlyBehavior(new FlyWithWings());
		donald.setQuackBehavior(new Quack());
		donald.display();
		donald.performQuack();
		donald.performFly();
	}
}
