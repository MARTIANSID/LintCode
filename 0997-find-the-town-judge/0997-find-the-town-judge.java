class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degree=new int[n+1];
        int[] indegree=new int[n+1];
        
        for(int[] t:trust){
            int u=t[0],v=t[1];
            indegree[v]++;
            degree[u]++;
        }
        for(int i=1;i<=n;i++){
            if(degree[i]==0 && indegree[i]==n-1)return i;
        }
        return -1;
    }
}