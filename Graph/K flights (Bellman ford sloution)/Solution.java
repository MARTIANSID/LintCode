class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
            return bellmanFord(n,flights,src,dst,k);
    }
     public int bellmanFord(int n,int[][] flights,int src,int dest,int k){
             int[] dist=new int[n];
             int[] ndist=new int[n];
             Arrays.fill(dist,(int)1e9);
             Arrays.fill(ndist,(int)1e9);
             
             dist[src]=0;
             ndist[src]=0;
             
             for(int stops=0;stops<=n;stops++){
                     for(int i=0;i<ndist.length;i++){dist[i]=ndist[i];}
                     if(stops==k+1)break;
                     
                     
                     for(int[] e:flights){
                             int u=e[0];
                             int v=e[1];
                             int w=e[2];
                             
                           
                             
                             if(dist[u]!=(int)1e9&&dist[u]+w<ndist[v]){
                                     ndist[v]=dist[u]+w;
                             }
                     }
                    
             }
             return dist[dest]==(int)1e9?-1:dist[dest];
     }   
}