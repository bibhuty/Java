/*
  	HashTable:
  		- A HashTable is an array of list.Each list is known as a bucket.The position of bucket is identified by calling the hashcode() method.A Hashtable contains values based on the key. It implements the Map interface and extends Dictionary class.
		- It contains only unique elements.
		- It may have not have any null key or value.
		- It is synchronized.
 */
package hashtable;

import java.util.Map;
import java.util.Hashtable;

public class HashTableImplementation {

	public static void main(String[] args) {

		Hashtable<Integer, String> id = new Hashtable<Integer,String>();
		id.put(01, "Bibhuti");
		id.put(99, "Noone");
		id.put(03,"Bonty");
		id.put(00, "Zero");
		
		for(@SuppressWarnings("rawtypes") Map.Entry m:id.entrySet())System.out.println("id = "+m.getKey()+" and name = "+m.getValue());
		
	}

}
