// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}// } Driver Code Ends


//User function Template for Java

class Solution
{
       static int[][] dp;
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
          dp=new int[m+1][n+1];
          int max=-(int)1e9;
        
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                
                if(X.charAt(i)==Y.charAt(j)){
                    dp[i][j]=dp[i+1][j+1]+1;
                   
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
                 max=Math.max(max,dp[i][j]);
            }
        }  
        
        
        // int value=solve(X,Y,0,0);
        
        return X.length()+Y.length()-max;
    }
    // public static int solve(String a,String b,int i,int j){
        
    //     if(i==a.length()||j==b.length())return 0;
        
    //     if(dp[i][j]!=null)return dp[i][j];
        
    //     if(a.charAt(i)==b.charAt(j)){
    //         return dp[i][j]= solve(a,b,i+1,j+1)+1;
            
    //     }else{
          
    //       int max=  Math.max(solve(a,b,i+1,j),solve(a,b,i,j+1));
    //         return dp[i][j]= max;
    //     }
        
    // }
}