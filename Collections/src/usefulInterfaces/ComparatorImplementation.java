/*
  Comparator Interface:
  	~ It is used to order the objects in user-defined classes
  	~ It has 2 methods in it:
  		- compare(Object obj1,Object obj2)
  		- equals(Object element)
  	~ 
 */
package usefulInterfaces;

import java.util.ArrayList;
import java.util.Collections;

public class ComparatorImplementation {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList<AgeOfBride> names = new ArrayList<AgeOfBride>();
		names.add(new AgeOfBride("Kareena", 31));
		names.add(new AgeOfBride("Katrina", 22));
		names.add(new AgeOfBride("Bipasa", 40));
		names.add(new AgeOfBride("Alieana", 25));
		
		Collections.sort(names,new AgeComparator());
		
		for(AgeOfBride b:names)System.out.println("Name is "+b.name+" and Age is "+b.age);


	}

}
