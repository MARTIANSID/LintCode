class Solution {
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        
        for(int i=0;i<manager.length;i++){
            if(manager[i]!=-1){
                graph.get(manager[i]).add(i);
            }
        }
        
        return dfs(graph,informTime,headID)+informTime[headID];
        
    }
    
    public int dfs(List<List<Integer>> graph,int[] informTime,int src){
        
        int max=0;
        for(int child:graph.get(src)){
            max=Math.max(max,dfs(graph,informTime,child)+informTime[child]);
        }
        
        return max;
        
        
    }
}