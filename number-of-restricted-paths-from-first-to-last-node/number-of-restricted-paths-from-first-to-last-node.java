class Solution {
        int mod=(int)1e9+7;
        class Pair{
                int vrtx;
                int weight;
                Pair(int vrtx,int weight){
                        this.vrtx=vrtx;
                        this.weight=weight;
                }
        }
    public int countRestrictedPaths(int n, int[][] edges) {
        ArrayList<ArrayList<Pair>> graph=new ArrayList<>();
            
            
           
            
           for(int i=1;i<=n+1;i++){
                   
                   graph.add(new ArrayList<>());
                   
           }
            
            for(int i=0;i<edges.length;i++){
                    
                    
                    graph.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
                    graph.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));

                    

            }
            
            PriorityQueue<Pair> que=new PriorityQueue<>((a,b)->{
                   return a.weight-b.weight;
            });
            
            
            boolean[] visited=new boolean[n+1];
            int[] weights=new int[n+1];
            
            
            que.add(new Pair(n,0));
            
            while(que.size()!=0){
                    
                    int size=que.size();
                    
                    while(size-->0){
                            
                            Pair p=que.remove();
                            
                            if(visited[p.vrtx]){
                                    continue;
                            }
                            // System.out.println(p.vrtx);
                            
                            weights[p.vrtx]=p.weight;
                            
                            visited[p.vrtx]=true;
                            
                            for(Pair child:graph.get(p.vrtx)){
                                    
                                    if(visited[child.vrtx]!=true){
                                            
                                            que.add(new Pair(child.vrtx,child.weight+p.weight));

                                    }
                            }
                    }
            }
            
            boolean[] visi=new boolean[n+1];
            long[] dp=new long[n+1];
        Arrays.fill(dp,-1);
            
            return (int)dfs(graph,1,visi,weights,n,dp);
            
          // for(int i=0;i<weights.length;i++){
          //         System.out.println(weights[i]);
          // }
            
           
            
            
    }
        
        public long dfs(ArrayList<ArrayList<Pair>> graph,int src,boolean[] visited,int[] weights,int n,long[] dp){
                
                if(src==n){
                        return dp[src]=1;
                }
                
                if(dp[src]!=-1)return dp[src];
                
                
                long count=0;
                for(Pair child:graph.get(src)){
                        if(weights[child.vrtx]<weights[src]){
                             count=(count+   dfs(graph,child.vrtx,visited,weights,n,dp))%mod;
                                
                        }
                }
                
             
                
                return dp[src]=count;
        }
}