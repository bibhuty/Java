/*
  Comparable Interface:
  	- It is used to sort the objects in user defined class
  	- It has only one method compareTo(Object)
  	- We can sort elements of:
  		~ String object
  		~ Wrapper class object
  		~ User defined object
 */
package usefulInterfaces;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableImplementation {

	public static void main(String[] args) {
		
		ArrayList<AgeOfBride> names = new ArrayList<AgeOfBride>();
		names.add(new AgeOfBride("Kareena", 31));
		names.add(new AgeOfBride("Katrina", 22));
		names.add(new AgeOfBride("Bipasa", 40));
		names.add(new AgeOfBride("Alieana", 25));
		
		Collections.sort(names);
		
		for(AgeOfBride b:names)System.out.println("Name is "+b.name+" and Age is "+b.age);

	}

}
