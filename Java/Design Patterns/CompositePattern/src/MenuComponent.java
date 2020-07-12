
public abstract class MenuComponent {
	
	public void add(MenuComponent menuComponent) {
		//if the component won't override, it means it will throw exception
		throw new UnsupportedOperationException();
	}
	
	public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	
	public MenuComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}
	
	//operation methods used by leaf class (MenuItem)
	public String getName() {
		throw new UnsupportedOperationException();
	}
	
	public String getDescription() {
		throw new UnsupportedOperationException();
	}
	
	public double getPrice() {
		throw new UnsupportedOperationException();
	}
	
	public boolean isVegetarian() {
		throw new UnsupportedOperationException();
	}
	
	//both leaf and composite should implement this
	public void print() {
		throw new UnsupportedOperationException();
	}
}
