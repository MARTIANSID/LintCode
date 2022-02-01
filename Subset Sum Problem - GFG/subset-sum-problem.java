// { Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int n, int arr[], int k){
             int[] cur=new int[k+1];
        int[] next=new int[k+1];
        
       
        
        for(int index=n;index>=0;index--){
            for(int i=0;i<=k;i++){
                if(i==0){
                    cur[i]=1;
                    continue;
                }
         if(index==arr.length){
            cur[i]=-1;
            	continue;
        }
                boolean take=false;
				 if(i-arr[index]>=0)
                   take=next[i-arr[index]]==-1?false:true;
               	boolean dontTake=next[i]==-1?false:true;
                
                boolean result=take||dontTake;
                
                cur[i]=result==false?-1:1;
                
            }
            next=cur;
            if(index!=0)
                cur=new int[k+1];
        }
        
        return cur[k]==-1?false:true;
    }
}