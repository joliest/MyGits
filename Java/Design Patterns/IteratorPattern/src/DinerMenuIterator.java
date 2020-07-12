import java.util.Iterator;
public class DinerMenuIterator implements Iterator {
	
	MenuItem[] menuItem;
	int position = 0;
	
	public DinerMenuIterator(MenuItem[] menuItem) {
		this.menuItem = menuItem;
	}

	@Override
	public boolean hasNext() {
		if(position >= menuItem.length || menuItem[position] == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Object next() {
		MenuItem item = menuItem[position];
		position += 1;
		return item;
	}

	@Override
	public void remove() {
		if(menuItem.length <= 0) {
			throw new IllegalStateException("You cannot remove an item until you've done at least one next()");
		} 
		
		if(menuItem[position-1] != null) {
			for(int i = position-1; i < (menuItem.length - 1); i++) {
				menuItem[i] = menuItem[i+1];
			}
			menuItem[menuItem.length - 1] = null;
		}
	}
	
	

}
