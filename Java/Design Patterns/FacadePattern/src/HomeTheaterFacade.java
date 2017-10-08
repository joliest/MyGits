import subsystems.Amplifier;
import subsystems.CdPlayer;
import subsystems.DvdPlayer;
import subsystems.PopcornPopper;
import subsystems.Projector;
import subsystems.Screen;
import subsystems.TheaterLights;
import subsystems.Tuner;

public class HomeTheaterFacade {
	
	//these are all the components of the subsystem we are going to use.
	Amplifier amp;
	Tuner tuner;
	DvdPlayer dvd;
	CdPlayer cd;
	Projector projector;
	TheaterLights lights;
	Screen screen;
	PopcornPopper popper;
	
	/*
	 	The Facade is passed a reference to 
	 	each component of the subsystem in its Constructor. 
	 	The facade then assigns each to the corresponding variable
	 */
	public HomeTheaterFacade(Amplifier amp,
							Tuner tuner,
							DvdPlayer dvd,
							CdPlayer cd,
							Projector projector,
							Screen screen,
							TheaterLights lights,
							PopcornPopper popper) {
		this.amp = amp;
		this.tuner = tuner;
		this.dvd = dvd;
		this.cd = cd;
		this.projector = projector;
		this.screen = screen;
		this.lights = lights;
		this.popper = popper;
	}
	
	//implementing simplified interface
	public void watchMovie(String movie) {
		
		System.out.println("Get ready to watch a movie... ");
		
		popper.on();
		popper.pop();
		
		lights.dim(10);
		
		screen.down();
		
		projector.on();
		projector.wideScreenMode();
		
		amp.on();
		amp.setDvd(dvd);
		amp.setSorroundSound();
		amp.setVolume(5);
		
		dvd.on();
		dvd.play(movie);
	}
	
	public void endMovie() {
		System.out.println("Shutting movie theater down...");
		
		popper.off();
		
		lights.on();
		
		screen.up();
		
		projector.off();
		
		amp.off();
		
		dvd.stop();
		dvd.eject();
		dvd.off();
	}
}
