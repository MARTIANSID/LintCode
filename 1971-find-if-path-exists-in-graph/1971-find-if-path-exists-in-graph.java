class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph=new ArrayList<>();
        
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] e:edges){
            int u=e[0],v=e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        boolean[] visited=new boolean[n];
        
        
        return dfs(graph,visited,source,destination);
    }
    
    
    public boolean dfs(List<List<Integer>> graph,boolean[] visited,int src,int dest){
        if(src==dest){
            return true;
        }
        
        visited[src]=true;
        
        for(int child:graph.get(src)){
            if(!visited[child]){
                boolean path=dfs(graph,visited,child,dest);
                if(path)return true;
            }
        }
        
        return false;
    }
}