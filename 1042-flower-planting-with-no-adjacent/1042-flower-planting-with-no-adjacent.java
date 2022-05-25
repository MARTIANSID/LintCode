class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        
        List<List<Integer>> graph=new ArrayList<>();
        
        for(int i=0;i<=n;i++)graph.add(new ArrayList<>());
        
        for(int[] p:paths){
            int u=p[0],v=p[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        int[] colors=new int[n];
        boolean[] visited=new boolean[n+1];
        
        
        for(int i=1;i<=n;i++){
            if(!visited[i])
            dfs(graph,i,visited,colors);
        }
        
        
        
        return colors;
        
    }
    
    public void dfs(List<List<Integer>> graph,int src,boolean[] visited,int[] colors){
        
        visited[src]=true;
        
        for(int child : graph.get(src)){
            if(!visited[child]){
                dfs(graph,child,visited,colors);
            }
        }
        HashSet<Integer> set=new HashSet<>();
        for(int child:graph.get(src)){
            set.add(colors[child-1]);
        }
        for(int i=1;i<=4;i++){
            if(!set.contains(i)){
                colors[src-1]=i;
                break;
            }
        }
    }
    
}