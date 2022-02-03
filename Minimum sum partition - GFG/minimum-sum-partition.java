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
         static boolean[][] dp;
	public int minDifference(int arr[], int n) 
	{ int sum=0;
        for(int ele:arr)sum+=ele;
        
        
        int target=sum;
        

        dp=new boolean[n+1][target+1];
        
        
        
        for(int i=n;i>=0;i--){
            for(int j=0;j<=target;j++){
                 if(i>=n&&j==0){
                       dp[i][j]= true;
                     	continue;
                 }
                 if(i>=n){
                     dp[i][j]= false;
                     continue;
                 }
           boolean take=false;
        
        if(j>=arr[i])
         take=dp[i+1][j-arr[i]];
        
        boolean leave=dp[i+1][j];
        
        	dp[i][j] =leave||take;
        
                
            }
        }
        
        int min=(int)1e9;
        
        for(int i=0;i<=target;i++){
            if(dp[0][i]==true){
                min=Math.min(min,Math.abs((sum-i)-i));
            }
        }
        
        
        return min;
        
        
	} 
}
