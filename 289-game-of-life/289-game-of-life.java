class Solution {
    //1->0 -1
    //0->1  2
    //1->1  1
    //0->0  0
    int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } };

    public void gameOfLife(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    int oneCount = ones(i, j, matrix);

                    if (oneCount == 3) {
                        matrix[i][j] = 2;
                    }
                } else {
                    int oneCount = ones(i, j, matrix);
                    if (oneCount < 2) {
                        matrix[i][j] = -1;
                    } else if (oneCount == 2 || oneCount == 3) {} else {
                        matrix[i][j] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                } else if (matrix[i][j] == 2) {
                    matrix[i][j] = 1;
                }
            }
        }
    }

    public int ones(int i, int j, int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int ones = 0;
        for (int k = 0; k < 8; k++) {
            int row = i + dir[k][0];
            int col = j + dir[k][1];

            if (row < n && col < m && row >= 0 && col >= 0 && (matrix[row][col] == 1 || matrix[row][col] == -1)) {
                ones++;
            }
        }
        return ones;
    }

    public int zeros(int i, int j, int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int zeros = 0;
        for (int k = 0; k < 8; k++) {
            int row = i + dir[k][0];
            int col = j + dir[k][1];

            if (row < n && col < m && row >= 0 && col >= 0 && (matrix[row][col] == 0 || matrix[row][col] == 2)) {
                zeros++;
            }
        }
        return zeros;
    }
}
