// { Driver Code Starts
//Initial Template for Java


//Initial Template for Java



import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


class Solution
{
    long sumoflength(long arr[] ,int n)
    {
       int ei=0,si=0,count=0,max=0;
       HashMap<Long,Integer> map=new HashMap<>();
       
       while(ei<n){
          map.put(arr[ei],map.getOrDefault(arr[ei],0)+1);
          if(map.get(arr[ei])>1)count++;
          ei++;
          while(count>=1 && si<ei){
              map.put(arr[si],map.get(arr[si])-1);
              if(map.get(arr[si])==1)count--;
              si++;
          }
          int x=ei-si;
          max+=((x*(x+1))/2);
       }
       return max;
    }
}


// { Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            int n=Integer.parseInt(br.readLine());
//            String line = br.readLine();
//            String[] a2 = line.trim().split("\\s+");
//            int n =Integer.parseInt(a2[0]);
//            int k =Integer.parseInt(a2[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[]=new long[n];
            for(int  i=0;i<n;i++)
            {
                a[i]=Long.parseLong(a1[i]);
            }
            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.sumoflength(a,n);
            System.out.println(ans);
        }
    }
}




  // } Driver Code Ends