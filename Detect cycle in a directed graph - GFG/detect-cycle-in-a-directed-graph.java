// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> graph) {
        // code here
        int[] visited=new int[v];
        
        for(int i=0;i<v;i++){
            if(visited[i]==0){
            boolean isCycle=detectCycle(graph,i,visited);
                if(isCycle)return true;
            }
        }
        
        return false;
        
        
    }
    
    public boolean detectCycle(ArrayList<ArrayList<Integer>> graph,int src,int[] visited)
    {
        
        visited[src]=1;
        
        for(int child:graph.get(src)){
            
            if(visited[child]==0){
            boolean isCycle=detectCycle(graph,child,visited);
            
            if(isCycle)return true;
                
            }else if(visited[child]==1){
                return true;
            }
            
        }
        
        visited[src]=-1;
        
        return false;
        
    }
}