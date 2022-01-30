// { Driver Code Starts
//Initial Template for Java


//Initial Template for Java



import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


class Solution
{
    long findMaxSubarraySum(long arr[], int N,int X)
    {
        long sum=0,max=0;
        
        int ei=0,si=0,n=arr.length;
        
        while(ei<n){
            sum+=arr[ei++];
            while(sum>X){
                sum-=arr[si++];
            }
            max=Math.max(max,sum);
        }
        return max;
    }
    
}


// { Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine().trim());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
//            String line = br.readLine();
//            String[] q = line.trim().split("\\s+");
//            int n =Integer.parseInt(q[0]);
//            int m =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
//            String line2 = br.readLine();
//            String[] a2 = line2.trim().split("\\s+");
//            long b[] = new long[n];
//            for (int i = 0; i < n; i++) {
//                b[i] = Long.parseLong(a2[i]);
//            }
            Solution ob = new Solution();
            long ans=ob.findMaxSubarraySum(a,n,k);
            System.out.println(ans);
        }
    }
}



  // } Driver Code Ends