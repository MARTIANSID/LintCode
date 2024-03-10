class Solution {
    
    class pair{
        int node;
        int weight;
        
        pair(int node,int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        
        List<List<pair>> graph = new ArrayList<>();
        
        int n = edges.length + 1;
        
        int[] ans = new int[n];
        
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            int u = e[0], v = e[1], w = e[2];
            graph.get(u).add(new pair(v,w));
            graph.get(v).add(new pair(u,w));
        }
        
        for(int i=0; i<=edges.length;i++){
            
            int possibleNodes = 0, res = 0;
            for(pair child : graph.get(i)){
                
                int childNode = child.node, weight = child.weight;
                
                int cnt = dfs(graph,childNode,signalSpeed,i,weight);
                
                res += possibleNodes*cnt;
                possibleNodes+=cnt;
            }
            ans[i] = res;
        }
        
        return ans;
        
    }
    
    public int dfs(List<List<pair>> graph, int src, int signalSpeed,int parent,int distance){
        
        int cnt = 0;
        
        if(distance%signalSpeed == 0) cnt++;
        
        for(pair child : graph.get(src)){
            int node = child.node, weight = child.weight;
            if( node!= parent){
                cnt+=dfs(graph,node,signalSpeed,src,distance+weight);
            }
        }
        return cnt;
    }
}