class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] matrix=new int[n+1][m+1];
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                matrix[i][j]=matrix[i][j-1]+matrix[i-1][j]-matrix[i-1][j-1]+mat[i-1][j-1];
            }
        }
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int row1=Math.max(0,i-k)+1;
                int row2=Math.min(n-1,i+k)+1;
                int col1=Math.max(0,j-k)+1;
                int col2=Math.min(m-1,j+k)+1;
            
                mat[i][j]=matrix[row2][col2]-matrix[row2][col1-1]-matrix[row1-1][col2]+matrix[row1-1][col1-1];
                
            }
        }
        return mat;
    }
}