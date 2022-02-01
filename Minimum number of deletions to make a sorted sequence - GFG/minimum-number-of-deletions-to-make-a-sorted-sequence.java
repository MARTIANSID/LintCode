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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDeletions(Arr,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java
class Solution
{
	public int minDeletions(int arr[], int n) 
	{ 
	   //code here.
	   int[] dp=new int[n];
	   int om=0;
	   for(int i=n-1;i>=0;i--){
	       for(int j=i+1;j<n;j++){
	           if(arr[j]>arr[i])
	           dp[i]=Math.max(dp[i],dp[j]+1);
	       }
	       
	       om=Math.max(om,dp[i]);
	   }
	   
	   return n-om-1;
	} 
}