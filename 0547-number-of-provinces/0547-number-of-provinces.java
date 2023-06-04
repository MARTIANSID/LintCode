class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        int[] parent=new int[n+1];
        int[] size=new int[n+1];
            
            for(int i=1;i<=n;i++){
                    parent[i]=i;
                    size[i]=1;
            }
            int count=0;
            
         for(int i=0;i<isConnected.length;i++){
                  
                for(int j=0;j<isConnected[0].length;j++){
                        if(i!=j){
                               if(isConnected[i][j]==1){
                                    int p1=   findParent(i+1,parent);
                                    int p2=   findParent(j+1,parent);
                                       
                                       if(p1!=p2){
                                               count++;
                                              parent[p1]=p2;
                                              
                                       }
                                     
                               }
                        }
                }
         }
            return n-count;
    }
        
        public int findParent(int u,int[] parent){
                if(parent[u]==u){
                        return u;
                }
                
             int p=  findParent(parent[u],parent);
                
                parent[u]=p;
                return p;
        }
        
        
}