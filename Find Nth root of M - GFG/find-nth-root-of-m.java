// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int getAssumedRoot(int m,int n,int val){
        long temp=1;
        
        while(n-->0){
        
        temp*=m;
        if(temp>val)return (int)temp;
        
    }

        return (int)temp;
    }
    
    public int NthRoot(int n, int m)
    {
       int si=0;
       int ei=m;
       
       while(si<=ei){
           int mid=si+(ei-si)/2;
          
           int r= (int)Math.pow(mid,n);
           
           if(r==m)return mid;
           
           if(r>m||r<0){
               ei=mid-1;
           }else{
               si=mid+1;
           }
       }
       return -1;
    }
}