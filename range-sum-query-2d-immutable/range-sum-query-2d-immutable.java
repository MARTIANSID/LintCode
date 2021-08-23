class NumMatrix {
    int n;
    int m;
    int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        this.n=matrix.length;
        this.m=matrix[0].length;
        this.prefixSum=new int[n+1][m+1];
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                prefixSum[i][j]=matrix[i-1][j-1]+prefixSum[i-1][j]+prefixSum[i][j-1]-prefixSum[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        row1++;
        row2++;
        col1++;
        col2++;
        
        return prefixSum[row2][col2]-prefixSum[row2][col1-1]-prefixSum[row1-1][col2]+prefixSum[row1-1][col1-1];
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */