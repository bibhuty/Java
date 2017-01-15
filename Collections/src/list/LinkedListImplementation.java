/*
	LinkedList:
		- Doubly Linked List
		- Fast manipulation as no shifting is required
		- It can be used as list, stack or queue 
		- It can act as both list and queues as it implements both list and deque interface
*/

package list;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListImplementation {

	public static void main(String[] args) {
		LinkedList<String> students = new LinkedList<String>();
		students.add("Bonty");
		students.add("Bhusan");
		students.add("Bibhuti");
		students.addFirst("Hero");
		students.addLast("Zero");
	
		
		Collections.sort(students);		
		System.out.println("The students are: ");
		@SuppressWarnings("rawtypes")
		Iterator itr = students.iterator();
		while(itr.hasNext())System.out.println(itr.next());

	}

}
