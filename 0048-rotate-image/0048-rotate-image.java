class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        
        // Transpose
        
        for(int i = 0; i < n; i++) {
            for(int j = i; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Reverse columns
        
        for(int[] row : matrix) {
            for(int i = 0; i < m / 2; i++) {
                int temp = row[i];
                row[i] = row[m-i-1];
                row[m-i-1] = temp;
            }
        }
    }
}

// [[1,2,3],[4,5,6],[7,8,9]]
  
// 1 4 7   1 4 7
// 2 5 8 -> 2 5 8
// 3 6 9    3 6 9


// first row - > last column
// last column - > last row
// last row - > first column


// second row - > third column
// third column - > third row


// for(int i = 0; i < lastRow; i++) {
//     for(int j = 0; j < i; j++){
        
//     }
// }

// [[1,2], [3,4]] - > [[1,3], [2,4]] -> [[3,1], [4,2]]

// 1 3 -> 1 3
// 2 4    2 4


// 0,1 - 1,0

// // first find the transpose

// swap(matrix[i][j],matrix[j][i])

// reverse columns
    
    

