/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	  Scanner sys=new Scanner(System.in);
	int t=sys.nextInt();
	while(t-->0){
	    int n=sys.nextInt();
	    int k=sys.nextInt();
	    int[] arr=new int[n];
	    for(int i=0;i<n;i++){
	        arr[i]=sys.nextInt();
	    }
	    
	    PriorityQueue<Integer> pq=new PriorityQueue<>();
	    int[] ans=new int[n];
	    int j=0;
	    for(int i=0;i<n;i++){
	        pq.add(arr[i]);
	        if(pq.size()==k){
	           ans[j]= pq.poll();
	           j++;
	        }
	    }
	    
	    while(pq.size()!=0){
	        ans[j]=pq.poll();
	        j++;
	    }
	    
	    for(int i=0;i<n;i++){
	        System.out.print(ans[i]+" ");
	    }
	    System.out.println();
	    
	}
	
    }
}