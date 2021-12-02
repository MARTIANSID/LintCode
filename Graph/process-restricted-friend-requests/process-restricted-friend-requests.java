class Solution {
    public int findParent(int u,int[] parent){
        
        if(parent[u]==u)return u;
        
      int x=  findParent(parent[u],parent);
      
        return x;
    }
    
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        
        
        int[] parent=new int[n];
        
        boolean[] ans=new boolean[requests.length];
        
        for(int i=0;i<n;i++)parent[i]=i;
        
        int index=0   ;     
            for(int[] r:requests){
            int u=r[0];
            int v=r[1];
            int p1= findParent(u,parent);
            int p2=findParent(v,parent);
                boolean flag=false;
                int y;
            if(p1!=p2){
                y=parent[p1];
                parent[p1]=p2;
                
                for(int[] rt:restrictions){
                    int u1=rt[0];
                    int v1=rt[1];
                    
             int pa1= findParent(u1,parent);
            int pa2=findParent(v1,parent);
                    if(pa1==pa2){
                        flag=true;
                        break;
                    }
                }
                 if(flag){
                    parent[p1]=y;
                    ans[index]=false;
                }else{
                    ans[index]=true;
                }

                  
            }else{
                 ans[index]=true;
            }
                index++;
                
        }
        
        return ans;
        
        
    }
}