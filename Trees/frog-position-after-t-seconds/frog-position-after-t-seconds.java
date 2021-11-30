class Solution {
    double ans=1.0;
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++)graph.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] visited=new boolean[n+1];
       boolean val= dfs(graph,t,target,1,visited,1);
        System.out.println(val);
        if(!val)return 0;
        return ans;
        
        
    }
    public boolean dfs(List<List<Integer>> graph,int t,int target,int src,boolean[] visited,double prob){
        
        if(src==target){
            if(t==0){
                                   
                ans=prob;
                return true;
            }
            else if(t>0){
                if(src==1&&graph.get(src).size()==0){
                     ans=prob;
                    return true;
                   
                }else if(src!=1&&graph.get(src).size()-1==0){
                    ans=prob;
                    return true;
                }else{
                                       

                     visited[src]=true;
                    return false;
                }

            }
            else{
                 visited[src]=true;
                return false;
            }
            
        }
        visited[src]=true;
        
        
        for(int child:graph.get(src)){
            if(!visited[child]){
                visited[child]=true;
                double p= (double)((double)1/(src==1?(double)graph.get(src).size():(double)graph.get(src).size()-1));
               
                if(dfs(graph,t-1,target,child,visited,prob*p)){
                    return true;
                }
            }
        }
        return false;
    }
}