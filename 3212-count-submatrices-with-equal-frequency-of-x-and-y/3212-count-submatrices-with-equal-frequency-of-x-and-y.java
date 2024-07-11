class Solution {

    class pair {
        int countOfX = 0;
        int countOfY = 0;

        pair(int countOfX, int countOfY) {
            this.countOfX = countOfX;
            this.countOfY = countOfY;
        }
    }

    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        pair[][] dp = new pair[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = new pair(0, 0);
            }
        }

        int cnt = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                pair p1 = dp[i - 1][j];
                pair p2 = dp[i][j - 1];
                pair p3 = dp[i - 1][j - 1];

                dp[i][j] = new pair(p1.countOfX + p2.countOfX - p3.countOfX, p1.countOfY + p2.countOfY - p3.countOfY);

                if (grid[i - 1][j - 1] == 'X') {
                    dp[i][j].countOfX++;
                } else if (grid[i - 1][j - 1] == 'Y') {
                    dp[i][j].countOfY++;
                }

                if (dp[i][j].countOfX == dp[i][j].countOfY && dp[i][j].countOfX != 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
