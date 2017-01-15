/*
 * LinkedHashSet:
 * 	- It contains only unique elements like HashSet
 *  - It extends HashSet class and implements Set interface
 *  - It maintains the insertion order	
 */
package set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetImplementation {

	public static void main(String[] args) {
		
		LinkedHashSet<String> id = new LinkedHashSet<String>();
		id.add("abc123");
		id.add("234bcd");
		id.add("345cde");
		id.add("abc123");
		
		@SuppressWarnings("rawtypes")
		Iterator it = id.iterator();
		System.out.println("The id's are as follows");
		while(it.hasNext())System.out.println(it.next());
	}

}
