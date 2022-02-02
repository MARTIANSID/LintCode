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
		    //taking the String
		    String s=sc.nextLine();
		    Solution ob = new Solution();
		    //calling method sumSubstrings() 
		    System.out.println(ob.sumSubstrings(s));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    static int mod=(int)1e9+7;
    //Function to find sum of all possible substrings of the given string.
    public static long sumSubstrings(String s)
    {
    //Your code here
        int n=s.length();
        
        long[] dp=new long[n];
        
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(i==0){
                dp[i]=Long.parseLong(ch+"");
            }else{
                dp[i]=((dp[i-1]*10)%mod+((i+1)*Long.parseLong(ch+""))%mod)%mod;
                
            }
        }
        
        long sum=0;
        
        for(long ele:dp){
            sum=(sum%mod+ele%mod)%mod;
        }
        
        return sum;
        
    }
}