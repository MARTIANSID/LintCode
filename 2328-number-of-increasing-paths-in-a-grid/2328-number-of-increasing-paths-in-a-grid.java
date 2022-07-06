class Solution {
    Long[][] dp;
    int mod=(int)1e9+7;
    public int countPaths(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new Long[n][m];
        
        long count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                count=(count+dfs(i,j,grid,-1))%mod;
            }
        }
        return (int)(count%mod);
    }
    public long dfs(int i,int j,int[][] grid,int val){
        if(i>=grid.length || j>=grid[0].length || i<0 || j<0 || grid[i][j]<=val){
            return 0;
        }
        
        if(dp[i][j]!=null)return dp[i][j];

        long count=0;
        count=(count+dfs(i+1,j,grid,grid[i][j]))%mod;
        count=(count+dfs(i,j+1,grid,grid[i][j]))%mod;
        count=(count+dfs(i-1,j,grid,grid[i][j]))%mod;
        count=(count+dfs(i,j-1,grid,grid[i][j]))%mod;
        
        return  dp[i][j]=count+1;
        
    }
}