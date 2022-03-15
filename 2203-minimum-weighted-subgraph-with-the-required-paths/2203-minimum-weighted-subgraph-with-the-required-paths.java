class Solution {
    
    class Edge{
        int vrtx;
        long weight;
        Edge(int vrtx,long weight){
            this.vrtx=vrtx;
            this.weight=weight;
        }
    }
    
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        
        List<List<Edge>> graph=new ArrayList<>();
        
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        
        for(int[] e:edges){
            graph.get(e[0]).add(new Edge(e[1],e[2]));
        }
        
        long[] src1Distances=dijkstra(graph,src1,n);
        long[] src2Distances=dijkstra(graph,src2,n);
        
         List<List<Edge>> reverseGraph=new ArrayList<>();
        
        for(int i=0;i<n;i++)reverseGraph.add(new ArrayList<>());
        
        
         for(int[] e:edges){
            reverseGraph.get(e[1]).add(new Edge(e[0],(long)e[2]));
        }
        
        long[] destDistances=dijkstra(reverseGraph,dest,n);
        
        long min=(long)1e11;
        
        for(int i=0;i<n;i++){
            min=Math.min(min,(src1Distances[i]+src2Distances[i]+destDistances[i]));
        }
        

        return min==(long)1e11?-1:min;
    }
    public long[] dijkstra(List<List<Edge>> graph,int src,int n){
        
        long[] distances=new long[n];
        
        Arrays.fill(distances,(long)1e11);
        
        PriorityQueue<Edge> pq=new PriorityQueue<>((a,b)->{
           
            return (int)(a.weight-b.weight);
        });
        
        boolean[] visited=new boolean[n];
        
        
        
        pq.add(new Edge(src,0));
        
        while(pq.size()!=0){
            int size=pq.size();
            while(size-->0){
               Edge v= pq.poll();
                
               if(visited[v.vrtx])continue;
                distances[v.vrtx]=v.weight;
                visited[v.vrtx]=true;
                
                for(Edge child:graph.get(v.vrtx)){
                    if(!visited[child.vrtx]){
                        pq.add(new Edge(child.vrtx,v.weight+child.weight));
                    }
                }
            }
        }
        
        return distances;
        
    }
}