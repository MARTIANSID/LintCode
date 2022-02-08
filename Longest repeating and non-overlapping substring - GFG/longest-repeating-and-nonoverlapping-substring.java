// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S, N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String longestSubstring(String s, int n) {
        // code here
        
        int[][] dp=new int[n+1][n+1];
        
        int max=0;
        int row=-1,col=-1;
        
        
        for(int i=n;i>=0;i--){
            for(int j=n;j>=0;j--){
                if(i==n||j==n)
                {
                    dp[i][j]=0;
                    continue;
                }
                
                if(i==j){
                    dp[i][j]=0;
                    continue;
                }
                
                if(i>j){
                    continue;
                }
                
                if(s.charAt(i)==s.charAt(j)){
                int val = j>(i+dp[i+1][j+1])?dp[i+1][j+1]:((dp[i+1][j+1]+1)-j); 
                    dp[i][j]=val+1;
                    if(dp[i][j]>=max){
                        row=i;
                        col=j;
                        max=dp[i][j];
                    }
                }else{
                    dp[i][j]=0;
                }
            }
        }
        
        
       
        
      
      String ans="";
      
      if(row==-1||col==-1)return "-1";
      
    
     
        
        return s.substring(row,row+dp[row][col]);
        
    }
};