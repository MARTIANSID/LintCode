class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||j==0||j==m-1||i==n-1)dfs1(grid,i,j);
            }
        }
        
        
        int ans=0;
           for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)ans++;
            }
        }
        return ans;
        
    }
    
    void dfs1(int[][] grid,int i,int j)
    {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0)
            return ;
        
        grid[i][j] = 0;
        
        dfs1(grid,i+1,j);
        dfs1(grid,i-1,j);
        dfs1(grid,i,j+1);
        dfs1(grid,i,j-1);
    }
}