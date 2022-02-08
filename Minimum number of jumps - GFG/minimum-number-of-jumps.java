// { Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}
// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        // your code here
        int n=arr.length;
        
        if(n==1)return 0;
        
        int max=arr[0];
        
        int jumps=1;
        
        int i=0;
            
        while(i<n)
        {
            
           

            int m=max;
            
            if(max>=(n-1))return jumps;
            
            while(i<=m){
                max=Math.max(max,arr[i]+i);
                i++;
            }
            
            jumps++;    
                            
            if(m==max)return -1;
            
            if(max>=(n-1))return jumps;
            
            
        }
        
        return jumps;
    
    }
}