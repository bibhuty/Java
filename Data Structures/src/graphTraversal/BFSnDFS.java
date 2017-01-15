package graphTraversal;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFSnDFS {

	public static void main(String[] args) {
		
		int V=5;
		Graph g = new Graph(V);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(4, 5);
		System.out.println("BFS");
		g.BFS(0);
		System.out.println("\n\nDFS");
		g.DFS_Iterative(0);
		System.out.println("\n\nEnitre list is");
		g.printList();
	}
	
	static class Graph{
		int V;
		ArrayList<Integer>[] G;
		
		//Constructor for the initialization of number of vertices
		//and the empty ArrayList corresponding to each vertices
		@SuppressWarnings("unchecked")
		public Graph(int V) {
			this.V=V;
			G = new ArrayList[V+1];
			for(int v=0;v<=V;++v)G[v]=new ArrayList<Integer>();
		}
		
		//Method for adding an edge from x to y
		public void addEdge(int x,int y){
			G[x].add(y);
		//In case of undirected graph following will do its job
			//G.get(y).add(x);
		}
		
		/*BFS*/
		void BFS(int s){
			//It is there to memorize if a vertex is visited or not
			boolean[] isVisited=new boolean[V+1];
			
			//It is there to help traverse all the possible vertices. It is the core for BFS
			LinkedList<Integer> queue = new LinkedList<Integer>();
			
			//Push the initial vertex to the queue and mark it as traversed
			queue.push(s);
			isVisited[s]=true;
			
			//Pop a vertex from the queue and print it as traversed
			//Push all the adjacent vertices to the queue which are not visited
			//and mark them as visited
			while(!queue.isEmpty()){
				s=queue.poll();
				System.out.print(s + " ");
				for(int v:G[s]){
					if(!isVisited[v]){
						queue.add(v);
						isVisited[v]=true;
					}
				}
			}
		}
		
		/*DFS*/
		void DFS_Iterative(int s){
			//It is there to memorize if a vertex is visited or not
			boolean[] isVisited=new boolean[V+1];
			
			//It is there to help traverse all the possible vertices. It is the core for DFS
			LinkedList<Integer> stack = new LinkedList<Integer>();
			
			//Push the initial element to the stack
			stack.push(s);	
			
			//Pop a vertex from the stack and mark it as visited
			//Push all the adjacent vertices to the auxiliary stack which are not visited
			//Pop all the elements from the auxiliary stack and push them into the main stack
			while(!stack.isEmpty()){
				s=stack.pop();
				isVisited[s] = true;
				System.out.print(s+" ");
				LinkedList<Integer> auxiliaryStack = new LinkedList<Integer>();
				for(int v:G[s]){
					if(!isVisited[v])auxiliaryStack.push(v);
					while(!auxiliaryStack.isEmpty())stack.push(auxiliaryStack.pop());
				}
			}
		}
		
		void DFS_Recursive(int s){
			
		}
		
		//printing the total adjacency list
		void printList(){
			for(int v=0;v<=V;++v){
				System.out.println(v + " has the neighbour " + G[v]);
			}
		}
		
	}

}

