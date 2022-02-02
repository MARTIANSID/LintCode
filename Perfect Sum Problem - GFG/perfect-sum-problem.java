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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    // } Driver Code Ends


class Solution{
    
    Long[][] dp;
    int mod=(int)1e9+7;

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    
	    
	    dp=new Long[n][sum+1];
	    
	    
	    return (int)(solve(arr,sum,0)%mod);
	   
	} 
	
	public long solve(int[] arr,int sum,int index){
	    
	    int n=arr.length;
	    
	    
	    
	    if(sum==0&&index==n)return 1;
	    
	    
	    if(index>=n)return 0;
	    
	   if(dp[index][sum]!=null)return dp[index][sum];
	   
	   
	    long count=0;
	    	    
	   
	    
	    
	    if(arr[index]<=sum)
	    count= (count%mod+solve(arr,sum-arr[index],index+1)%mod)%mod;
	    
	    count=(count%mod+ solve(arr,sum,index+1)%mod)%mod;

	    return dp[index][sum]=count;
	    
	}
}