class Solution {
    public int findChampion(int n, int[][] edges) {
        
        int[] indegree=new int[n]; 
        
        for(int[] edge:edges){
            int u=edge[0],v=edge[1];
            indegree[v]++;
        }
        int cnt=0,node=-1;
        
        for(int i=0;i<n;i++){
            if(indegree[i]>0){
            }else{
                node=i;
                cnt++;
            }
        }
        if(cnt>1)return -1;
        
        return node;

    }
}