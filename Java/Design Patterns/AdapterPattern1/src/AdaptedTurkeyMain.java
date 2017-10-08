
public class AdaptedTurkeyMain {
	public static void main(String[] args) {
		WildTurkey turkey = new WildTurkey();
		
		TurkeyAdapter turkeyAdapted = new TurkeyAdapter(turkey);
		turkeyAdapted.fly();
		turkeyAdapted.quack();
	}
}
