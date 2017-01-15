/*
 	TreeMapInterface:
 		- It implements NavigableMap and extends Map
 		- It is similar to the TreeMap except it arranges the item in sorted ascending order
 */
package map;

import java.util.TreeMap;
import java.util.Map;

public class TreeMapImplementation {

	public static void main(String[] args) {
		TreeMap<Integer, String> id = new TreeMap<Integer,String>();
		id.put(01, "Bibhuti");
		id.put(99, "Noone");
		id.put(03,"Bonty");
		id.put(00, "Zero");
		
		for(@SuppressWarnings("rawtypes") Map.Entry m:id.entrySet())System.out.println("id = "+m.getKey()+" and name = "+m.getValue());
		
	
	}

}
