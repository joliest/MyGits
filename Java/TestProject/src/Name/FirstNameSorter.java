package Name;

import java.util.Comparator;

public class FirstNameSorter implements Comparator<Name> {

	@Override
	public int compare(Name a, Name b) {
		return a.getFname().compareTo(b.getFname());
	}

}
