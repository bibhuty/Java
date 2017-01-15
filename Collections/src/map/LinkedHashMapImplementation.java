/*
 	LinkedHashMap:
 		- It is similar to HashMap except for it maintains the insertion order
 
*/

package map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapImplementation {

	public static void main(String[] args) {
		LinkedHashMap<Integer, String> id = new LinkedHashMap<Integer,String>();
		id.put(01, "Bibhuti");
		id.put(03,"Bonty");
		id.put(99, "NoOne");
		id.put(00, "Zero");
		
		for(@SuppressWarnings("rawtypes") Map.Entry m:id.entrySet())System.out.println("id = "+m.getKey()+" and name = "+m.getValue());
		
	
	}

}
