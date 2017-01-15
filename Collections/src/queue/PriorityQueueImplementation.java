/*
  Priority Queue:
  	- The queue interface order the elements in FIFO manner
  	- Priority Queue gives the interface of the queue interface except for the FIFO
  	- Methods of the queue interface are:
  		~ public boolean add(object);
		~ public boolean offer(object);
		~ public remove();
		~ public poll();
		~ public element();
		~ public peek();
 */

package queue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueImplementation {

	public static void main(String[] args) {

		PriorityQueue<String> names = new PriorityQueue<String>();
		names.add("Sachin");
		names.add("Rahul");
		names.add("Dhoni");
		names.add("Kohli");
		names.add("Raina");
		
		//element() 
		//It gives the top item but doesn't throws any exception if the queue is empty
		System.out.println("At the top we can find "+ names.element());
		
		//peek()
		//It also gives a top item but throws an exception if the queue is empty
		System.out.println("The best indian captain till now is "+names.peek());
		
		System.out.println("==============================");
		
		System.out.println("Iterating the elements of the queue");
		@SuppressWarnings("rawtypes")
		Iterator itr = names.iterator();
		while(itr.hasNext())System.out.println(itr.next());
		
		//remove()
		//It retrieves and removes the head of the queue and doesn't throws exception when the queue is empty
		names.remove();
		
		//poll
		//It retrieves and removes the head of the queue and returns null in case of empty queue
		names.poll();
		
		System.out.println("===============================");
		System.out.println("After removing 2 elements the queue have");

		@SuppressWarnings("rawtypes")
		Iterator it = names.iterator();
		while(it.hasNext())System.out.println(it.next());
		
		
		
	}

}
