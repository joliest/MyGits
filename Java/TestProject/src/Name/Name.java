package Name;

public class Name implements Comparable<Name>{
	
	public Name(String fname, String lname) {
		setFname(fname);
		setLname(lname);
	}
	
	private String fname;
	private String lname;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String toString() {
		return fname + " " + lname;
	}
	
	
	@Override /* Override compareTo from Comparable<? super T> */
	public int compareTo(Name o) {
		return this.fname.compareTo(o.getFname());
	}
	
	/*required for HashSet
	@Override
	public boolean equals(Object obj) {
		Name name = (Name) obj;
		return this.getFname().equals(name.getFname());
	}

	@Override
	public int hashCode() {
		return fname.hashCode();
	}
	
	*/
}
