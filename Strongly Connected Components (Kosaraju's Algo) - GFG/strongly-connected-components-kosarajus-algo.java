// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int v, ArrayList<ArrayList<Integer>> adj)
    {
        
        Stack<Integer> st=topoSort(adj,v);
        List<List<Integer>> tGraph=transpose(adj,v);
        // System.out.println(tGraph);
        boolean[] visited=new boolean[v];
        
        int cnt=0;
        // System.out.println(st);
        
        while(st.size()!=0){
            int c=st.pop();
            if(!visited[c]){
                dfs(tGraph,visited,c);
                cnt++;
            }
        }
        return cnt;
        
        
    }
    
    public void topo(Stack<Integer> st,ArrayList<ArrayList<Integer>> adj,boolean[] visited,int n,int src){
        visited[src]=true;
       
        for(int child:adj.get(src)){
            if(!visited[child])
            topo(st,adj,visited,n,child);
        }
        st.add(src); 
    }
    
    public Stack<Integer> topoSort(ArrayList<ArrayList<Integer>> adj,int n){
        Stack<Integer> st=new Stack<>();
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i])
            topo(st,adj,visited,n,i); 
        }
           
      
        return st;
    }
    
    public List<List<Integer>> transpose(ArrayList<ArrayList<Integer>> adj,int n){
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
       for(int i=0;i<adj.size();i++){
            ArrayList<Integer> childs=adj.get(i);
            for(int j=0;j<childs.size();j++){
               graph.get(childs.get(j)).add(i);
            }
        }
        return graph;
    }
    
    public void dfs(List<List<Integer>> graph,boolean[] visited,int src){
        visited[src]=true;
        
        for(int child:graph.get(src)){
            if(!visited[child]){
                dfs(graph,visited,child);
            }
        }
    }
}
