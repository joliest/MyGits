
public class Whip extends CondimentDecorator{
	
	Beverage beverage;
	
	public Whip(Beverage bev) {
		beverage = bev;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", whip";
	}

	@Override
	public double cost() {
		double cost = beverage.cost() + .10;
		return cost;
	}

}
