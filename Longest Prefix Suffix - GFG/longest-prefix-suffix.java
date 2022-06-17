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
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int lps(String s) {
        int n=s.length();
        int[] lps=new int[n];
        int i=1;
        lps[0]=0;
        int len=0,max=0;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i]=len;
                i++;
               
            }else{
                if(len>0){
                    len=lps[len-1];
                }else{
                    i++;
                }
            }
        }
        return lps[n-1];
        
    }
}