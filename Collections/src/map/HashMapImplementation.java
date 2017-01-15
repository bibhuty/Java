/*
 	Map:
 		- A map contains elements as key-value pair(or entry) with unique keys.
 		- Map is useful when we have to search, delete or update on the basis of key
 		- Some useful functions are:
			~ public Object put(Object key, Object value)	.
			~ public void putAll(Map map)
			~ public Object remove(Object key)
			~ public Object get(Object key)
			~ public boolean containsKey(Object key)
			~ public Set keySet()
			~ public Set entrySet()
		- Methods of Map.Entry interface
			~ public Object getKey()
			~ public Object getValue()
*/

/*
  HashMap:
  	- A HashMap contains values based on the key. It implements the Map interface and extends AbstractMap class.
	- It contains only unique elements.
	- It may have one null key and multiple null values.
	- It maintains no order.
  
 */
package map;

import java.util.HashMap;
import java.util.Map;

public class HashMapImplementation {

	public static void main(String[] args) {
		
		HashMap<Integer, String> id = new HashMap<Integer,String>();
		id.put(01, "Bibhuti");
		id.put(03,"Bonty");
		id.put(99, "NoOne");
		
		for(@SuppressWarnings("rawtypes") Map.Entry m:id.entrySet())System.out.println("id = "+m.getKey()+" and name = "+m.getValue());
		
	}

}
