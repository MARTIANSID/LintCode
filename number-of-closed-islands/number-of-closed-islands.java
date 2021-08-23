class Solution {
    boolean toCount=true;
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]&&grid[i][j]==0){
                    dfs(grid,i,j,visited);
                    if(toCount)ans++;
                    toCount=true;
                }
            }
        }
        return ans;
    }
    
    public void dfs(int[][] grid,int row,int col,boolean[][] visited){
        
        int n=grid.length;
        int m=grid[0].length;
        if(row>=n||col>=m||row<0||col<0||grid[row][col]==1||visited[row][col])return;
        
        visited[row][col]=true;
        if(row==0||col==0||row==n-1||col==m-1)toCount=false;
        
        dfs(grid,row+1,col,visited);
        dfs(grid,row-1,col,visited);
        dfs(grid,row,col+1,visited);
        dfs(grid,row,col-1,visited);
        
        
    }
}