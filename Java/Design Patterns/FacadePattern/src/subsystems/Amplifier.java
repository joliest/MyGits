package subsystems;

public class Amplifier {
	
	DvdPlayer dvd;

	public void on() {
		System.out.println("Amplifier is on");
	}

	public void setDvd(DvdPlayer dvd) {
		this.dvd = dvd;
		System.out.println("DVD is set");
	}

	public void setSorroundSound() {
		System.out.println("Sorround Sound enabled");
	}

	public void setVolume(int i) {
		System.out.println("Volume is set to " + i);
	}

	public void off() {
		System.out.println("Amplifier turned off");
	}

}
