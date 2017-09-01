
public class Soy extends CondimentDecorator{
	
	Beverage beverage;
	
	public Soy(Beverage bev) {
		beverage = bev;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", soy";
	}

	@Override
	public double cost() {
		double cost = beverage.cost() + .15;
		return cost;
	}

}
