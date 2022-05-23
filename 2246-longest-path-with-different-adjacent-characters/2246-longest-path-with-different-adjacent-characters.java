class Solution {
    int globalMax=0;
    public int longestPath(int[] parent, String s) {
        int n=parent.length;
        List<List<Integer>> graph=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            if(parent[i]!=-1){
                graph.get(parent[i]).add(i);
                graph.get(i).add(parent[i]);
            }
        }
        
        dfs(graph,s,0,-1);
        
        return globalMax;
        
    }
    public int dfs(List<List<Integer>> graph,String s,int src,int parent){
        
        int max=0,sMax=0;
        
        for(int child:graph.get(src)){
            if(child!=parent){
                int val=dfs(graph,s,child,src);
                if(s.charAt(child)!=s.charAt(src)){
                    if(val>max){
                        sMax=max;
                        max=val;
                        
                    }else if(val>sMax){
                        sMax=val;
                    }
                }
            }
        }
        globalMax=Math.max(globalMax,max+sMax+1);
        
        return max+1;
    }
}