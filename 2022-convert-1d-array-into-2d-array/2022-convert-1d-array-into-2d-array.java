class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        
        int size=original.length;
        
        if(size!=n*m)return new int[][]{};
        
         int[][] matrix=new int[m][n];
         
         for(int i=0;i<size;i++){
             int r=i/n;
             int c=i%n;
             matrix[r][c]=original[i];
         }
        return matrix;
    }
}