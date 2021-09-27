class Solution {
    
    public int findParent(int[] parent,int u){
        if(parent[u]==u)return u;
        
        int x=findParent(parent,parent[u]);
        parent[u]=x;
        return x;
        
    }
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
            //union find 
        
        int[] parent=new int[n+1];
        for(int i=0;i<=n;i++)parent[i]=i;
        List<Boolean> ans=new ArrayList<>();
        
        for(int i=1;i<=n;i++){
            for(int j=2*i;j<=n;j+=i){
                if(i>threshold){
                int p1= findParent(parent,i);
                int p2=findParent(parent,j);
                    if(p1!=p2){
                        parent[p1]=p2;
                    }
                }
            }
        }
        for(int i=0;i<queries.length;i++){
            int p1=findParent(parent,queries[i][0]);
            int p2=findParent(parent,queries[i][1]);
            ans.add(p1==p2);
   
        }
        return ans;
        
    }
}