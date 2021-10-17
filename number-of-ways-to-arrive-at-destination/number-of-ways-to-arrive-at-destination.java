class Solution {
      class Edge{
                int weight=0;
                int vrtx=0;
               
                
                Edge(int weight,int vrtx){
                        this.weight=weight;
                        this.vrtx=vrtx;     
                }
        }
    public int countPaths(int n, int[][] edges) {
        List<List<int[]>> graph=new ArrayList<>();
        int mod=(int)1e9+7;
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        
        for(int[] e:edges){
            int  u=e[0];
            int v=e[1];
            int w=e[2];
            graph.get(u).add(new int[]{v,w});
            graph.get(v).add(new int[]{u,w});
        }
        
         PriorityQueue<Edge> que = new PriorityQueue<>((a,b)->{
                     return a.weight-b.weight;
             });
            
       
            que.add(new Edge(0,0));
            boolean[] visited=new boolean[n];
            
           
            
           int[] distance=new int[n];
        Arrays.fill(distance,(int)1e11);
      
            int[] ways=new int[n];
            ways[0]=1;
            while(que.size()!=0){
                    
                  Edge  e=  que.remove();
                    
                    if(visited[e.vrtx]){
                            continue;
                    }
                
                    visited[e.vrtx]=true;
                    for(int[] child:graph.get(e.vrtx)){    
                        if(e.weight+child[1]<distance[child[0]]){
                            ways[child[0]]=ways[e.vrtx];
                            distance[child[0]]=e.weight+child[1];
                        }else if(e.weight+child[1]==distance[child[0]]){
                            ways[child[0]]=(ways[child[0]]+ways[e.vrtx])%mod;
                        }
                        
                         que.add(new Edge(e.weight+child[1],child[0]));
                             
                    }
            }
        
        
        
        
        
        
        return ways[n-1];
    }
}