class Solution {
    int max=-1;
    public int longestCycle(int[] edges) {
        int n=edges.length;
        
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        
        for(int i=0;i<n;i++){
            if(edges[i]!=-1)
            graph.get(i).add(edges[i]);
        }
        int[] visited=new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(graph,visited,i,-1);
            }
        }
        return max;
        
    }
    public void dfs(List<List<Integer>> graph,int[] visited,int src,int par){
        visited[src]=1;
        
        for(int child:graph.get(src)){
            if(visited[child]==0){
                dfs(graph,visited,child,src);
            }else if(visited[child]==1 && src!=par){
                //cycle
                int vrtx=child,cnt=0;
                while(graph.get(child).size()>0 && graph.get(child).get(0)!=vrtx){
                    cnt++;
                    child=graph.get(child).get(0);
                }
                max=Math.max(max,cnt+1);
            }
        }
        visited[src]=2;
    }
}