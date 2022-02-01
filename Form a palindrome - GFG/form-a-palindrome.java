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
    int[][] dp;
    int findMinInsertions(String s){
        // code here
        int n=s.length();
        // dp=new int[n][n];
        
        int[] cur=new int[n];
        int[] next=new int[n];
        
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                 if(i>=j){
                cur[j]= 0;
                continue;
                }
                
                if(s.charAt(i)==s.charAt(j)){
             cur[j]=next[j-1];
        }else{
             cur[j]= Math.min(next[j],cur[j-1])+1;
        }
                
            }
            next=cur;
            if(i!=0)
            cur=new int[n];
        }
        
        
        return cur[n-1];
        // return solve(s,0,n-1);
    }
    
    // public int solve(String s,int i,int j){
        
       
        
    //     if(i>=j){
    //         return 0;
    //     }
        
    //     if(dp[i][j]!=null)return dp[i][j];
        
        // if(s.charAt(i)==s.charAt(j)){
        //     return dp[i][j]= solve(s,i+1,j-1);
        // }else{
        //     return dp[i][j]= Math.min(solve(s,i+1,j),solve(s,i,j-1))+1;
        // }
        
    // }
}