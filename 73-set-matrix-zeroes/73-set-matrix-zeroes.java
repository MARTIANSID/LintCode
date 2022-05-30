class Solution {

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            boolean isRow = false;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    isRow = true;
                    break;
                }
            }
            if (isRow) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] != 0) {
                        matrix[i][j] = (int)1e9;
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            boolean isCol = false;
            for (int j = 0; j < n; j++) {
                if (matrix[j][i] == 0) {
                    isCol = true;
                    break;
                }
            }
            if (isCol) {
                for (int j = 0; j < n; j++) {
                    if (matrix[j][i] != 0) {
                        matrix[j][i] = (int)1e9;
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == (int)1e9) {
                    matrix[i][j]=0;
                }
            }
           
        }
    }
}
