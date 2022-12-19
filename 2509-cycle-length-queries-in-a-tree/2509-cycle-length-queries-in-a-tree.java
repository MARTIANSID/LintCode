class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int m=queries.length;
        //find lca in log n
        //then reach till lca node from the query nodes
        int[] ans=new int[m];
        int index=0;
        
       
        for(int[] q:queries){
            int u=q[0],v=q[1];
            ans[index++]=cycleSum(u,v)+1;
        }
        return ans;
    
    }
    public int cycleSum(int u,int v){
        
        if(u==v)return 0;
        
        if(u>v){
            u=u/2;
        }else{
            v=v/2;
        }
        
        return cycleSum(u,v)+1;
    }
}