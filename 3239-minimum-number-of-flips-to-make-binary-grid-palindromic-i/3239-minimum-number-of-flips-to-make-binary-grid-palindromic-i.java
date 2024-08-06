class Solution {
    public int minFlips(int[][] grid) {
        
        int n = grid.length;
        
        int m = grid[0].length, flipRow = 0, flipCol = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m / 2; j++) {
                if(grid[i][j] != grid[i][m - j - 1]) {
                    flipRow++;
                }
            }
        }
        
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n / 2; j++) {
                if(grid[j][i] != grid[n - j - 1][i]) {
                    flipCol++;
                }
            }
        }
        
        return Math.min(flipRow,flipCol);
    
    }
}