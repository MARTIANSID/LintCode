// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to swap odd and even bits.
    public static int swapBits(int n) 
    {
	    int[] mask=new int[32];
	    
	    for(int i=0;i<32;i++){
	        int x=1<<i;
	        mask[i]=(n&x)==0?0:1;
	    }
	    for(int i=0;i<31;i+=2){
	        swap(i,i+1,mask);
	    }
	    int no=0,index=0;
	    for(int ele:mask){
	        if(ele==1)
	        no+=(1<<index);
	        index++;
	    }
	    return (int)no;
	}
	public static void swap(int i,int j,int[] mask){
	    int temp=mask[i];
	    mask[i]=mask[j];
	    mask[j]=temp;
	}
    
}

// { Driver Code Starts.

class BitWise{

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//taking n
		    
		    Solution obj = new Solution();
		    
		    //calling swapBits() method of class
		    //Swap
		    System.out.println(obj.swapBits(n));
		}
	}
}  // } Driver Code Ends