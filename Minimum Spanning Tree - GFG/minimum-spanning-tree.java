// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    
    public static  int findParent(int u,int[] parent){
        if(parent[u]==u)return u;
        
        int x=findParent(parent[u],parent);
        parent[u]=x;
        return x;
    }
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
       int[] parent=new int[v];
       
       for(int i=0;i<v;i++)parent[i]=i;
       
       
       List<int[]> edges=new ArrayList<>();
       
       for(int i=0;i<adj.size();i++){
           ArrayList<ArrayList<Integer>> childs=adj.get(i);
           for(int j=0;j<childs.size();j++){
           ArrayList<Integer> child=    childs.get(j);
           int[] e=new int[3];
           e[0]=i;
           e[1]=child.get(0);
           e[2]=child.get(1);
           
           edges.add(e);
           
           }
       }
       
       Collections.sort(edges,(a,b)->{
           return a[2]-b[2];
           });
       
       
       int sum=0;
       for(int i=0;i<edges.size();i++){
          int u= edges.get(i)[0];
          int vv=edges.get(i)[1];
          
          int p1=findParent(u,parent);
          int p2=findParent(vv,parent);
          if(p1!=p2){
              sum+=edges.get(i)[2];
              parent[p1]=p2;
          }
       }
       
       return sum;
    }
}
