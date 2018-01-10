
public class DuckSimulator {
	public static void main(String[] args) {
		DuckSimulator simulator = new DuckSimulator();
		AbstractDuckFactory duckFactory = new CountingDuckFactory();
		
		simulator.simulate(duckFactory);
	}
	
	public void simulate(AbstractDuckFactory duckFactory) {
		//strategical pattern
		/*
		Quackable mallardDuck = new QuackCounter(new MallardDuck());
		Quackable redheadDuck = new QuackCounter(new RedheadDuck());
		Quackable duckCall = new QuackCounter(new DuckCall());
		Quackable rubberDuck = new QuackCounter(new RubberDuck());
		Quackable gooseDuck = new GooseAdapter(new Goose());
		*/
		
		//factory pattern
		//Quackable mallardDuck = duckFactory.createMallardDuck();
		Quackable redheadDuck = duckFactory.createRedheadDuck();
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		//Quackable gooseDuck = new GooseAdapter(new Goose());
		Quackable gooseDuck = duckFactory.createGoose();
				
		System.out.println("\nDuck Simulator with Composite - flocks");
		
		//composite pattern
		Flock flockOfDucks = new Flock();
		
		flockOfDucks.add(redheadDuck);
		flockOfDucks.add(duckCall);
		flockOfDucks.add(rubberDuck);
		flockOfDucks.add(gooseDuck);
		
		Flock flockOfMallards = new Flock();
		
		Quackable mallardOne = duckFactory.createMallardDuck();
		Quackable mallardTwo = duckFactory.createMallardDuck();
		Quackable mallardThree = duckFactory.createMallardDuck();
		Quackable mallardFour = duckFactory.createMallardDuck();
		
		flockOfMallards.add(mallardOne);
		flockOfMallards.add(mallardTwo);
		flockOfMallards.add(mallardThree);
		flockOfMallards.add(mallardFour);
		
		flockOfDucks.add(flockOfMallards);
		
		/*
		 //without the composite
		simulate(mallardDuck);
		simulate(redheadDuck);
		simulate(duckCall);
		simulate(rubberDuck);
		simulate(gooseDuck);
		*/
		
		System.out.println("\nDuck Simulator : Whole Flock Simulation");
		simulate(flockOfDucks);
		
		System.out.println("\nDuck Simulator : Mallard Flock Simulation");
		simulate(flockOfMallards);
		
		
		//Observer pattern
		System.out.println("\nDuck Simulator with Observer");
		Quackologist quackologist = new Quackologist();
		flockOfDucks.registerObserver(quackologist);
		simulate(flockOfDucks);
		
		redheadDuck.registerObserver(quackologist);		
		simulate(redheadDuck);
		
		//decorator pattern's output
		System.out.print("\nNumber of quacks: " + QuackCounter.getQuacks());
	}
	
	public void simulate(Quackable duck) {
		duck.quack();
	}
}
