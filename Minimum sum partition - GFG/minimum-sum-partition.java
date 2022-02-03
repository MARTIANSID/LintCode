// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
        //  static boolean[][] dp;
	public int minDifference(int arr[], int n) 
	{ int sum=0;
        for(int ele:arr)sum+=ele;
        
        
        int target=sum;
        

        // dp=new boolean[n+1][target+1];
        
        boolean[] curr=new boolean[target+1];
        
        boolean[] next=new boolean[target+1];
        
        
        
        for(int i=n;i>=0;i--){
            for(int j=0;j<=target;j++){
                 if(i>=n&&j==0){
                       curr[j]= true;
                     	continue;
                 }
                 if(i>=n){
                      curr[j]= false;
                     continue;
                 }
           boolean take=false;
        
        if(j>=arr[i])
         take=next[j-arr[i]];
        
        boolean leave=next[j];
        
        	curr[j] =leave||take;
        
                
            }
            next=curr;
            
            if(i!=0)
            curr=new boolean[target+1];
        }
        
        int min=(int)1e9;
        
        for(int i=0;i<=target;i++){
            if(curr[i]==true){
                min=Math.min(min,Math.abs((sum-i)-i));
            }
        }
        
        
        return min;
        
        
	} 
}
