class Solution {

    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] oneRow = new int[n];
        int[] zeroRow = new int[n];
        int[] oneCol = new int[m];
        int[] zeroCol = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    zeroRow[i]++;
                    zeroCol[j]++;
                } else {
                    oneRow[i]++;
                    oneCol[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = (oneRow[i] + oneCol[j]) - zeroRow[i] - zeroCol[j];
            }
        }
        return grid;
    }
}
