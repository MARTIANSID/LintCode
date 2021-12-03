class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        // i have been given the edges
        
        HashMap<Integer,List<Integer>> graph=new HashMap<>();
        int n=adjacentPairs.length+1;
        
        
        for(int[] edge:adjacentPairs){
            int u=edge[0];
            int v=edge[1];
            
          List<Integer> us=  graph.getOrDefault(u,new ArrayList<>());
            us.add(v);
            graph.put(u,us);

            List<Integer> vs=  graph.getOrDefault(v,new ArrayList<>());
            vs.add(u);
            graph.put(v,vs);
        }
        
        
        
        int node=-(int)1e9;
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            
            if(entry.getValue().size()==1){
                node=entry.getKey();
                break;
                
            }
	    
}
    

        
        if(node==-(int)1e9)return new int[]{};
        
        List<Integer> ans=new ArrayList<>();
        HashMap<Integer,Boolean> visited=new HashMap<>();
        dfs(graph,node,ans,visited);
        
        int[] result=new int[n];
        for(int i=0;i<ans.size();i++)result[i]=ans.get(i);
        
        return result;
    }
    
    public void dfs(HashMap<Integer,List<Integer>> graph,int src,List<Integer> ans,HashMap<Integer,Boolean> visited){
        
        ans.add(src);
        visited.put(src,true);
        for(int child:graph.get(src)){
            if(visited.getOrDefault(child,false)!=true)
            dfs(graph,child,ans,visited);
        }
        
    }
}