class TreeAncestor {
  /*
  Concept used is binary lifting
 https://www.youtube.com/watch?v=oib-XsjFa-M&t=37s (errichto)
 
 Every k can be written in  sum of powers of 2 obviously lol (every decimal number can be written in sum of power of 2s)
 
 so we will make our jump in those power of 2s (amazing)  
 so we need to precomupte the ancestors of each node in power of 2 (dp[i][j]) wher i is the node and j is the power of 2
 */ 
    

    
    
    int[][] dp;  //dp[i][j] i is the node j is the power of 2
    
    //make tree
    public List<List<Integer>> makeTree(int[] parent){
        int n=parent.length;
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            if(parent[i]!=-1){
                int u=i,v=parent[i];
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
        }
        return graph;
        
    }
    
    public void traverse(List<List<Integer>> tree,int src,int[] parent){
        dp[src][0]=parent[src];
        for(int i=1;i<20;i++){
            if(dp[src][i-1]==-1)break;
            dp[src][i]=dp[ dp[src][i-1] ][i-1];   /* for i=1
                                                    node->parent->grandparent(this is what we want)
                                                    so dp[i][0]->this gives us parent of node
                                                    now dp[ dp[i][0] ][0] ->this gives us the grandparent
                                                    follow this pattern
                                                  */
                
        }
        for(int child:tree.get(src)){
            if(child!=parent[src]){
                traverse(tree,child,parent);
            }
        }
    }
    
    public TreeAncestor(int n, int[] parent) {
       dp=new int[n][20];
       for(int[] r:dp){
           Arrays.fill(r,-1);
       }
       List<List<Integer>> tree= makeTree(parent);
       traverse(tree,0,parent);
    }
    
    public int getKthAncestor(int node, int k) {
        for(int i=0;i<20;i++){
            int x=(1<<i);
            int bit=(k&x)==0?0:1;
            if(bit==1){
                node=dp[node][i];
                if(node==-1)return -1;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */