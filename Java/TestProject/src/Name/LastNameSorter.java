package Name;

import java.util.Comparator;

public class LastNameSorter  implements Comparator<Name> {

	@Override
	public int compare(Name a, Name b) {
		return a.getLname().compareTo(b.getLname());
	}

}
