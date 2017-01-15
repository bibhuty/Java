/*
 * HashSet:
 * 	- It uses hashtable to store elements
 * 	- It contains unique elements only
 */
package set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetImplementation {

	public static void main(String[] args) {
		HashSet<String> id = new HashSet<String>();
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
