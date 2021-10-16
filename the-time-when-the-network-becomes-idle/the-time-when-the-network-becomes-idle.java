class Solution {
    
     class Edge{
                int weight=0;
                int vrtx=0;
               
                
                Edge(int weight,int vrtx){
                        this.weight=weight;
                        this.vrtx=vrtx;
                       
                }
        }
    
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        List<List<Integer>> graph=new ArrayList<>();
        
        //make graph
        
        int n=edges.length;
         int m=patience.length;
        for(int i=0;i<m;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
           
            int v=edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
       
        //Apply dikstra and find minimum time for each
         PriorityQueue<Edge> que = new PriorityQueue<>((a,b)->{
                     return a.weight-b.weight;
             });
            
       
            que.add(new Edge(0,0));
            boolean[] visited=new boolean[m];
            
           int[] distance=new int[m];
            
            while(que.size()!=0){
                    
                  Edge  e=  que.remove();
                    
                    if(visited[e.vrtx]){
                            continue;
                    }
                
                    distance[e.vrtx]=e.weight;
                            
                    visited[e.vrtx]=true;
                    for(int child:graph.get(e.vrtx)){
                           
                            if(visited[child]!=true){
                                
                                    que.add(new Edge(e.weight+1,child));
                            }   
                    }
            }
        
        int ans=0;
        
            for(int i=1;i<patience.length;i++){
              
                if(distance[i]*2<=patience[i]){
                    ans=Math.max(ans,distance[i]*2);
                }else{
                  int numberOfPackets=(int)Math.ceil((double)(2*distance[i]-patience[i])/(double)patience[i]);
                    
                    ans=Math.max(ans,(numberOfPackets)*patience[i]+distance[i]*2);
                }
            }
        
        return ans+1;
        
    }
}