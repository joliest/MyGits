package Test;
import java.util.*;

import Name.FirstNameSorter;
import Name.LastNameSorter;
import Name.Name;
public class Test {
	public static void main(String[] args) {
		LastNameSorter sortLastName = new LastNameSorter();
		TreeSet<Name> names = new TreeSet<Name>(sortLastName);
		//ArrayList<Name> names = new ArrayList<Name>();
		//HashSet<Name> namesNoDuplicate = new HashSet<Name>();
		
		Name arlene = new Name("Arlene", "Caguin");
		Name khaye = new Name("Khaye", "Gorres");
		Name noel = new Name("Noel", "Bondoc");
		Name joliver = new Name("Joliver", "Estampador");
		Name martha = new Name("Joliver", "Estampador");
		Name lheng = new Name("Juliana", "Estampador");
		Name rommar = new Name("Rommar", "Roxas");
		Name aera = new Name("Aera", "Bcash");
		
		names.add(arlene);
		names.add(khaye);
		names.add(noel);
		names.add(joliver);
		names.add(lheng);
		names.add(martha);
		names.add(rommar);
		names.add(aera);
		
		//namesNoDuplicate.addAll(names);
		
		//Demonstrating HashSet and avoid duplplicate. 
		//Overriding the arg object equals and hash
		System.out.println(names);
		System.out.println();
		//System.out.println(namesNoDuplicate);
		
		
		/* 
		//Demonstrating Comparable and Comparator
		System.out.println("Sorting using Comparable");
		Collections.sort(names);
		System.out.println(names);
		
		System.out.println("Sorting using LastNameSorter");
		LastNameSorter lastNameSorter = new LastNameSorter();
		Collections.sort(names, lastNameSorter);
		System.out.println(names);
		*/
		
		/*
		Iterator treeSet = samples.iterator();
		
		for(int i = 0; i < samples.size(); i++) {
			System.out.println((i+1) + ". " + treeSet.next());
		}
		*/
	}
}
