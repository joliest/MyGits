
public class WinnerState implements State{

	GumballMachine gumballMachine;
	
	public WinnerState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("");
	}

	@Override
	public void turnCrank() {
		System.out.println("");
	}

	@Override
	public void dispense() {
		System.out.println("You're a WINNER! You get two gumballs for your quarter");
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() == 0) {
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		} else {
			System.out.println("Oops, out of gumballs");
			gumballMachine.setState(gumballMachine.getSoldOutState());
			
		}
	}

}
