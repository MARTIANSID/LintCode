// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Pair
{
    int x;
    int y;
    
    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}

class Chainlength
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Pair pr[] = new Pair[n];
            int arr[] = new int[2*n];
            for(int i = 0; i < 2*n; i++)
            {
               arr[i] = sc.nextInt();
            }
            for(int i = 0, j = 0; i < 2*n-1 && j < n; i = i+2, j++)
            {
                pr[j] = new Pair(arr[i], arr[i+1]);
            }
            GfG g = new GfG();
            System.out.println(g.maxChainLength(pr, n));
        }
    }
}
// } Driver Code Ends


/*class CompareByFirst implements Comparator<Pair>
{
   public int compare(Pair a, Pair b)
    {
        return a.x - b.x;
    }
}*/

class GfG
{
    class pair{
        int end;
        int val;
        pair(int end,int val){
            this.end=end;
            this.val=val;
        }
    }
    
    int maxChainLength(Pair arr[], int n)
    {
        
       // your code here
       
       Arrays.sort(arr,(a,b)->{
           return a.x-b.x;
       });
       
       PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
           return a.end-b.end;
           
       });
       
       int max=0;
       int om=1;
       for(int i=0;i<n;i++){
           while(pq.size()>0&&pq.peek().end<arr[i].x){
               max=Math.max(max,pq.poll().val);
           }
           om=Math.max(om,max+1);
           pq.add(new pair(arr[i].y,max+1));
       }
       
       return om;
       
    }
}