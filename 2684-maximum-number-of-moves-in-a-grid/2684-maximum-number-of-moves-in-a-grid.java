class Solution {
    Integer[][] dp;

    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new Integer[n][m];
        int max=-1;

        for (int i = 0; i < n; i++) {
                max=Math.max(max,dfs(grid,i,0,-1));
        }
        return max-1;
    }

    public int dfs(int[][] grid, int row, int col, int prev) {
        if (row >= grid.length || col >= grid[0].length || row < 0 || grid[row][col] <= prev)
            return 0;

        if (dp[row][col] != null)
            return dp[row][col];
        
        int cnt = 0;

        cnt = Math.max(cnt,dfs(grid, row - 1, col + 1, grid[row][col]));
        cnt = Math.max(cnt,dfs(grid, row, col + 1, grid[row][col]));
        cnt = Math.max(cnt,dfs(grid, row + 1, col + 1, grid[row][col]));

        return dp[row][col] = cnt+1;

    }
}