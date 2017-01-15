/*
 * ArrayList:
 * 	- It maintains insertion order
 * 	- Random access is allowed
 * 	- It implements List interface
 * 	- Insertion is O(1) time 
 * 	- Deletion and other operation is tedious as it takes lots of shifting
 * 	- It can only be used as list
 */


package list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListImplementation {
	
	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) {
		ArrayList<String> boys = new ArrayList<String>();
		boys.add("John");
		boys.add("Joseph");
		boys.add("Bobby");
		
		ArrayList<String> girls = new ArrayList<String>();
		girls.add("Mary");
		girls.add("Pinky");
		girls.add("Bobby");
				

		//Iterating through enhanced for loop
		System.out.println("The boys are:");
		for(String obj:boys)System.out.println(obj);
		
		System.out.println("\n==========\n");		

		//Iterating through iterators
		System.out.println("The girls are:");
		Iterator itr = girls.iterator();
		while(itr.hasNext())System.out.println(itr.next());
		
		System.out.println("\n==========\n");
		
		//addAll(Collection c)
		//Here it adds all the elements of collection c to the invoked collection
		ArrayList<String> students = new ArrayList<String>();
		students.addAll(boys);
		students.addAll(girls);
		System.out.println("All the students are");
		for(String name:students)System.out.println(name);
		
		System.out.println("\n==========\n");
		
		//removeAll(Collection c)
		//Here it removed all the elements of the invoked collection if they are
		//in the given collection
		students.removeAll(boys);
		Iterator it = students.iterator();
		System.out.println("After removing all the boys from the students for any mischief the girls are");
		while(it.hasNext())System.out.println(it.next());
		
		System.out.println("\n==========\n");
		
		//retainAll(Collection c)
		//Here it retains the elements in the invoked collection which are common to collection c
		boys.retainAll(girls);
		System.out.println("There's a gay and he is " + boys.get(0));
		
	}

}
 