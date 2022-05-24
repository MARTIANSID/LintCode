class Solution {
    
    public int findParent(int[] parent,int u){
        if(parent[u] == u)return u;
        
        int x=findParent(parent,parent[u]);
        parent[u]=x;
        return x;
    }
    
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        Arrays.sort(edges,(a,b)->{
           return b[0]-a[0]; 
        });
        
        int[] alice=new int[n+1];
        
        for(int i=0;i<n+1;i++){
            alice[i]=i;
        }
        
        int[] bob=new int[n+1];
        
        for(int i=0;i<n+1;i++){
            bob[i]=i;
        }
        
        int removedEdges=0;
        
        for(int[] e:edges){
            int type=e[0],u=e[1],v=e[2];
            
        
            if(type == 1){
                
                int p1=findParent(alice,u);
                int p2=findParent(alice,v);
                
                if(p1!=p2){
                    alice[p1]=p2;
                }else{
                    removedEdges++;
                }
                
            }else if(type == 2){
                
                int p1=findParent(bob,u);
                int p2=findParent(bob,v);
                
                if(p1!=p2){
                    bob[p1]=p2;
                }else{
                    removedEdges++;
                }
                
            }else{
                
                int p1=findParent(alice,u);
                int p2=findParent(alice,v);
                
                int p3=findParent(bob,u);
                int p4=findParent(bob,v);
                
                if(p1!=p2){
                    alice[p1]=p2;
                }
                
                if(p3!=p4){
                    bob[p3]=p4;
                }
            
                if(p1==p2 && p3==p4){
                    removedEdges++;
                }
                
                
            }
        }
        
        for(int i=2;i<n+1;i++){
            if(findParent(alice,i)!=findParent(alice,i-1) || findParent(bob,i)!=findParent(bob,i-1)){
                return -1;
            }
        }
        
        return removedEdges;
        
    }
}