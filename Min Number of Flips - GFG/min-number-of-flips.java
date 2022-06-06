// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution ob = new Solution();
            
            System.out.println(ob.minFlips(S));
                        
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public int minFlips(String s) {
        // Code here
        
        //010..
        //1010
        boolean flag=false;
        int count1=0,count2=0;
        for(int i=0;i<s.length();i++){
            if(!flag){
                if(s.charAt(i)=='1'){
                count1++;
            }else{
                count2++;
            }
            }else{
                 if(s.charAt(i)=='0'){
                count1++;
            }else{
                count2++;
            }
            }
            
            flag=!flag;
            
        }
        return Math.min(count1,count2);
    }
}