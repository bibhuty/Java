package segmentTree;
/*
 * Segment Tree:
 * 	- It is used to execute ranged query quickly.
 * 	- Other options are making a matrix 
 * 		~ It gives an advantage of executing a query in O(1) time
 * 		~ The disadvantage is that it takes a lot of space when n is quite high
 *	- A SEGMENT TREE is a binary tree with leaves as the elements of the array.
 *	- While trying to find an answer in a Segment Tree 3 cases can occur:
 *		1. Partial overlap;
 *		2. Full overlap; and
 *		3. No overlap of ranges
 *	- If the length of the array is
 *		1. a power of 2 then the length of the array of segment tree is
 *				2*(length of array) - 1
 *		2. not a power of 2 then the length of the array of segment tree is 
 *				2*(next power of 2 nearer to the length of the array) - 1
 *	- If i is the index of the array in the Segment Tree then:
 *		~ 2i+1 is the left child
 *		~ 2i+2 is the right child
 *		~ (i-1)/2 is the parent
 *	- Time and space complexity to build the array of Segment Tree is O(n)
 *	- Searching in a segment tree takes O(log n) time
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SegmentTree {
	static int[] elements;
	static int[] segmentTree;
	static int[] lazyTree;
	public static void main(String...strings) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer in=new StringTokenizer(br.readLine());
		int n;
		n=Integer.parseInt(in.nextToken());
		elements=new int[n];
		segmentTree=new int[n];
		lazyTree=new int[n];
		for(int i=0;i<n;++i)elements[i]=Integer.parseInt(in.nextToken());
		Arrays.fill(segmentTree, Integer.MAX_VALUE);
		Arrays.fill(lazyTree, 0);
	}	
	private void constructTree(int low,int high,int pos){
		//If dividing the array doesn't have multiple elements in it then
		//the position of the segment should contain the current element
		if(low==high){
			segmentTree[pos]=elements[low];
			return;
		}
		
		//Calculation of the middle position so that the array could be partitioned
		int mid=(low+high)/2;
		
		//Recursive call for the construction of the tree
		constructTree(low, high, 2*pos+1);//left half construction of the segment tree
		constructTree(mid+1, high, 2*pos+2);//right half construction of the segment tree
		
		//Construction of the respective roots
		//Here its a case of minimum query
		segmentTree[pos]=Math.min(segmentTree[2*pos+1], segmentTree[2*pos+2]);
	}	
	private int rangeMinimumQuery(int qlow,int qhigh,int low,int high,int pos){
		//The case of total overlap
		if(qlow<=low && qhigh>=high)return segmentTree[pos];
		
		//The case of no overlap
		if(qlow>high || qhigh<low)return Integer.MAX_VALUE;
		
		//Finding the mid position for the recursive call
		int mid=(low+high)/2;
		
		//returning minimum from the left and the right tree
		return Math.min(rangeMinimumQuery(qlow, qhigh, low, mid, 2*pos+1),rangeMinimumQuery(qlow, qhigh, mid+1, high, 2*pos+2));
	}
	private void updateSegmentTreeLazy(int startRange,int endRange,int delta,int low,int high,int pos){
		//The impossible case
		if(low>high)return;
		
		//Make sure that all the required positions are updated
		//If not updated then update them and make their childs lazy
		if(lazyTree[pos]!=0){
			segmentTree[pos]+=lazyTree[pos];
			if(low!=high){//If the position is not a leaf node
				lazyTree[2*pos+1]+=lazyTree[pos];
				lazyTree[2*pos+2]+=lazyTree[pos];
			}
			lazyTree[pos]=0;
		}
		
		//The no overlap condition
		if(startRange>high || endRange<low)return;
		
		//The total overlap condition
		if(startRange<=low || endRange>=high){
			segmentTree[pos]+=delta;
			if(low!=high){//If the position is not a leaf node
				lazyTree[2*pos+1]+=delta;
				lazyTree[2*pos+2]+=delta;
			}
		}
		
		//The condition of partial overlap where we have to see both the sides
		int mid=(low+high)/2;
		
	}
}






























