package unionFind;

public class UnionFind {

	public static void main(String[] args){
		
		
	}
	
	static class NormalUnion{
		//It is the most basic form of Union-Find data structure
		//The problem is that for the union of 2 elements we need to de O(n) operation
		//So for the union of n elements we need O(n*n) operations which is inefficient
		int[] parent;
		int N;
		public NormalUnion(int n){
			N=n+1;
			parent=new int[N];
			for(int i=0;i<N;++i)parent[i]=i;
		}
		void union(int a,int b){
			int parentB=parent[b];
			for(int i=0;i<N;++i)if(parent[i]==parentB)parent[i]=parent[a];
			
		}
		boolean find(int a,int b){
			return parent[a]==parent[b]?true:false;
		}
	}
	
	static class IndirectUnion{
		//This doesn't change the parent of each and every element of the subset
		//Instead it maps from root to root
		//It will give problem when there is no cycle in the element of the subset
		//Another disadvantage is that it doesn't checks which subset has the minimum 
		//element during the union operation resulting linear time operations during union		
		int[] parent;
		int N;
		public IndirectUnion(int n){
			N=n+1;
			parent=new int[N];
			for(int i=0;i<N;++i)parent[i]=i;
		}
		int root(int i){
			while(parent[i]!=i)i=parent[i];
			return i;
		}
		void union(int a,int b){
			int rootA=root(a);
			int rootB=root(b);
			parent[rootB]=rootA;
		}
		boolean find(int a,int b){
			return root(a)==root(b)?true:false;
		}
	}
	
	static class UnionByRank{
		//Maintaining a balanced tree through union by rank
		//reduces the union and find function from N to log2 N
		int[] parent;
		int[] rank;
		int N;
		public UnionByRank(int n){
			N=n+1;
			parent=new int[N];
			rank=new int[N];
			for(int i=0;i<N;++i){
				parent[i]=i;
				rank[i]=1;
			}
		}
		int root(int i){
			while(parent[i]!=i)i=parent[i];
			return i;
		}
		void union(int a,int b){
			int rootA=root(a);
			int rootB=root(b);
			if(rank[rootA]<rank[rootB]){
				parent[rootA]=parent[rootB];
				rank[rootB]+=rank[rootA];
			}else{
				parent[rootB]=parent[rootA];
				rank[rootA]+=rank[rootB];
			}
		}
		boolean find(int a,int b){
			return root(a)==root(b)?true:false;
		}
	}

	static class UnionByRankAndPathCompression{
		//Maintaining a balanced tree through union by rank and
		//using path compression reduces the union and find function from N to log* N
		int[] parent;
		int[] rank;
		int N;
		public UnionByRankAndPathCompression(int n){
			N=n+1;
			parent=new int[N];
			rank=new int[N];
			for(int i=0;i<N;++i){
				parent[i]=i;
				rank[i]=1;
			}
		}
		int root(int i){
			while(parent[i]!=i)parent[i]=root(parent[i]);
			return i;
		}
		void union(int a,int b){
			int rootA=root(a);
			int rootB=root(b);
			if(rank[rootA]<rank[rootB]){
				parent[rootA]=parent[rootB];
				rank[rootB]+=rank[rootA];
			}else{
				parent[rootB]=parent[rootA];
				rank[rootA]+=rank[rootB];
			}
		}
		boolean find(int a,int b){
			return root(a)==root(b)?true:false;
		}
				
	}
}
