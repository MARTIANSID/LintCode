class Solution {
    
    class Edge{
        int node;
        int weight;
        Edge(int node,int weight){
            this.weight = weight;
            this.node = node;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<Edge>> graph = new ArrayList<>();
        
        boolean[] visited = new boolean[n+1];
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int [] t: times){
            int u = t[0], v = t[1], w = t[2];
            graph.get(u).add(new Edge(v,w));
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->{
            return a.weight - b.weight;
        }); // min heap
        
        
        pq.add(new Edge(k,0));
        
        int max = 0;
        
        
        while(pq.size() > 0){
            int size = pq.size();
            
            while(size --> 0){
                Edge e = pq.poll();
                int node = e.node, weight = e.weight;
                
                if(visited[node]) continue;
                
                visited[node] = true;
                
                max = Math.max(max,weight);
                
                for(Edge child: graph.get(node)){
                    if(!visited[child.node]){
                        pq.add(new Edge(child.node,child.weight+weight));
                    }
                }
                
                
            }
            
        }
        
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                return -1;
            }
        }
        
        return max;
    }
}