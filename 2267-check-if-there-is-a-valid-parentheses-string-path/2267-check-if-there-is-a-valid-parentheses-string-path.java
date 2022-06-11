class Solution {
    //3 states (i,j,balance)
    Integer[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new Integer[n][m][n + m];

        int val = solve(grid, 0, 0, 0);

        return val == 1 ? true : false;
    }

    public int solve(char[][] grid, int i, int j, int balance) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        int x = 0;
        if (grid[i][j] == '(') {
            x = balance + 1;
        } else {
            x = balance - 1;
        }

        if (x < 0) return 0;
        

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            if (x == 0) return 1; else return 0;
        }
        
        if(dp[i][j][balance]!=null)return 0;

        int d = solve(grid, i + 1, j, x);
        if (d == 1) return 1;
        int r = solve(grid, i, j + 1, x);
        if (r == 1) return 1;

        return dp[i][j][balance]= 0;
    }
}
