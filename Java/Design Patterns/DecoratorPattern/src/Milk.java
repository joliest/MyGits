
public class Milk extends CondimentDecorator{
	
	Beverage beverage;
	
	public Milk(Beverage bev) {
		beverage = bev;
	}

	@Override
				  
	public String getDescription() {
		return beverage.getDescription() + ", milk";
	}

	@Override
	public double cost() {
		double cost = beverage.cost() + .10;
		return cost;
	}

}
