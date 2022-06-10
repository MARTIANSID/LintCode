// { Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Long> find(long arr[], int n, int x)
    {
        
        
        long startingIndex=-1,endingIndex=-1;
        
      int s=  findFirstIndex(arr,x);
        
       int e= findLastIndex(arr,x);
       
       ArrayList<Long> ans=new ArrayList<>();
       ans.add((long)s);
       ans.add((long)e);
       return ans;
        
    }
    
    public int findFirstIndex(long[] arr,int x){
        int si=0,ei=arr.length-1;
        
        while(si<=ei){
            int mid=(si+ei)/2;
            if(arr[mid]>x){
                ei=mid-1;
            }else if(arr[mid]<x){
                si=mid+1;
            }else{
                if(mid-1>=0 && arr[mid-1]==x)ei=mid-1;
                else return mid;
            }
        }
        return -1;
    }
    
    public int findLastIndex(long[] arr,int x){
        int si=0,ei=arr.length-1;
        
        while(si<=ei){
            int mid=(si+ei)/2;
            if(arr[mid]>x){
                ei=mid-1;
            }else if(arr[mid]<x){
                si=mid+1;
            }else{
                if(mid+1<arr.length && arr[mid+1]==x)si=mid+1;
                else return mid;
            }
        }
        return -1;
    }
    
    
}



// { Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Long> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}
  // } Driver Code Ends