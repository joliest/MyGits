package subsystems;

public class DvdPlayer {

	public void on() {
		System.out.println("DVD Player is turned on");
	}

	public void play(String movie) {
		System.out.println("Playing " + movie);
	}

	public void stop() {
		System.out.println("Movie stopped");
	}

	public void eject() {
		System.out.println("DVD ejected");
	}

	public void off() {
		System.out.println("Dvd is turned off");
	}

}
