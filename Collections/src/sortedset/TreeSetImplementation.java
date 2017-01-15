/*
 * TreeSet:
 * 	- It contains unique elements just like HashSet
 * 	- It implements NavigableSet interface which extends SortedSet interface
 * 	- It maintains ascending order of items
 */

package sortedset;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetImplementation {

	public static void main(String[] args) {
		
		TreeSet<String> names = new TreeSet<String>();
		names.add("Bobo");
		names.add("Gandu");
		names.add("Alas");
		names.add("Hero");
		
		System.out.println("The names in ascending order are");
		@SuppressWarnings("rawtypes")
		Iterator it = names.iterator();
		while(it.hasNext())System.out.println(it.next());
		
	}

}
