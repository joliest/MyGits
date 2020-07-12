import subsystems.*;

public class HomeTheaterTestFDrive {
	public static void main(String[] args) {
		Amplifier amp = new Amplifier();
		CdPlayer cd = new CdPlayer();
		DvdPlayer dvd = new DvdPlayer();
		PopcornPopper popper = new PopcornPopper();
		Projector projector = new Projector();
		Screen screen = new Screen();
		TheaterLights lights = new 		TheaterLights();
		Tuner tuner = new Tuner();
		
		HomeTheaterFacade homeTheater = new HomeTheaterFacade(
				amp, tuner, dvd, cd, projector, 
				screen, lights, popper);
		
		homeTheater.watchMovie("Shawshank Redemption");
		homeTheater.endMovie();
	}
}
