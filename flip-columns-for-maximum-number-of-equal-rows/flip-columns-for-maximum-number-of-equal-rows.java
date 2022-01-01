class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int max=1;
        for(int i=0;i<n;i++){
            
           
            int count=0;
            for(int o=i;o<n;o++){
             int[] flip=new int[m];
            for(int j=0;j<m;j++)flip[j]=1-matrix[o][j];
                if(Arrays.equals(flip, matrix[i])||Arrays.equals(matrix[o],matrix[i])){
                    count++;
                }
            }
            max=Math.max(max,count);
        }
        
        return max;
    
    }
}