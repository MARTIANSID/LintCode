class Solution {
    
    class edge{
        int u;
        int weight;
        edge(int u,int weight){
            this.u=u;
            this.weight=weight;
        }
    }
    
    int val=0;
    
    public int minReorder(int n, int[][] connections) {
        List<List<edge>> graph=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] e:connections){
            int u=e[0],v=e[1];
            graph.get(u).add(new edge(v,0));
            graph.get(v).add(new edge(u,1));

        }
        boolean[] visited=new boolean[n];
        
        dfs(0,graph,visited);
        
        return n-1-val;
    }
    
    public void dfs(int src,List<List<edge>> graph,boolean[] visited){
        visited[src]=true;
        
        for(edge child:graph.get(src)){
            if(!visited[child.u]){
                val+=child.weight;
                dfs(child.u,graph,visited);
            }
        }
    }
}