class Solution {
    Boolean[] dp;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> g=new ArrayList<>();
        
        
        int n=graph.length;
        
        dp=new Boolean[n+1];
        
        boolean[] visited=new boolean[n+1];
        
        for(int i=0;i<n;i++){
            if(!visited[i])
            dfs(graph,i,visited);
        }
        
        List<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(dp[i])ans.add(i);
        }
        
        return ans;
        
        
    }
    public boolean dfs(int[][] graph,int src,boolean[] visited){
        
        visited[src]=true;
        
        if(graph[src].length == 0){
            dp[src]=true;
            return true;
        }
        if(dp[src]!=null)return dp[src];
        
        for(int child:graph[src]){
            if(visited[child] && (dp[child] == null || dp[child] == false)){
                dp[src]=false;
                return false;
            }
            if(!dfs(graph,child,visited)){
                dp[src]=false;
                return false;
            }
        }
        
        dp[src]=true;
        
        return true;
        
    } 
    
}