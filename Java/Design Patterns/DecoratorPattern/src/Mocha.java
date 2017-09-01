
public class Mocha extends CondimentDecorator {
	
	Beverage beverage;
	
	public Mocha(Beverage bev) {
		beverage = bev;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", mocha";
	}

	@Override
	public double cost() {
		double cost = beverage.cost() + .20;
		return cost;
	}

}
