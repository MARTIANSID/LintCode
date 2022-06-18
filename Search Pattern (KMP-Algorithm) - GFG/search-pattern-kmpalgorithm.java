// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        int on=pat.length();   
        pat=pat+"#"+txt;
        int n=pat.length();
        int[] lps=new int[n];
        int i=1,len=0;
        ArrayList<Integer> ans=new ArrayList<>();
        while(i<n){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]=len;
                if(lps[i]==on)ans.add(i-(on)-(on-1));
                i++;
            }else{
                if(len>0){
                    len=lps[len-1];
                }else{
                    i++;
                }
            }
        }
        if(ans.size()==0)ans.add(-1);
        return ans;
    
    }
}