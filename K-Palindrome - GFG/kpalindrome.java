// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String input_line[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            int k = Integer.parseInt(input_line[1]);
            String str = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.kPalindrome(str, n, k));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static  Integer[][] dp;
    
    static int kPalindrome(String str, int n, int k)
    {
        
        dp=new Integer[n][n];
        
        int val=solve(str,0,n-1,n);
        
        return val>k?0:1;
         
    }
    
    public static int solve(String str,int i,int j,int n){
        
        if(i>=j){
            return 0;
        }
        
        if(dp[i][j]!=null)return dp[i][j];
        
        if(str.charAt(i)==str.charAt(j)){
            return dp[i][j]= solve(str,i+1,j-1,n);
        }else{
            return dp[i][j]= Math.min(solve(str,i+1,j,n),solve(str,i,j-1,n))+1;
        }
        
        
        
    }
}