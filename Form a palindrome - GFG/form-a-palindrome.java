// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    Integer[][] dp;
    int findMinInsertions(String s){
        // code here
        int n=s.length();
        dp=new Integer[n][n];
        
        return solve(s,0,n-1);
    }
    
    public int solve(String s,int i,int j){
        
       
        
        if(i>=j){
            return 0;
        }
        
        if(dp[i][j]!=null)return dp[i][j];
        
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]= solve(s,i+1,j-1);
        }else{
            return dp[i][j]= Math.min(solve(s,i+1,j),solve(s,i,j-1))+1;
        }
        
    }
}