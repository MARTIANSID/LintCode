// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}

// } Driver Code Ends


class Solution
{
    static PriorityQueue<Integer> pqMax=new PriorityQueue<>((a,b)->{
        return b-a;
        });
        
   static PriorityQueue<Integer> pqMin=new PriorityQueue<>();
    //Function to insert heap.
    public static void insertHeap(int x)
    {
        
        if(pqMax.size()==pqMin.size()){
            pqMin.add(x);
            pqMax.add(pqMin.poll());
        }else{
            pqMax.add(x);
            pqMin.add(pqMax.poll());
        }
        // add your code here
        
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       // add your code here
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        if(pqMax.size()==pqMin.size()){
            return (double)(((double)pqMax.peek()+(double)pqMin.peek())/2);
        }else{
            return (double)pqMax.peek();
        }
        // add your code here
    }
    
}