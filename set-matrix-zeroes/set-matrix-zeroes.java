class Solution {
    public void setZeroes(int[][] matrix) {

        int n=matrix.length;
        int m=matrix[0].length;
        boolean firstRow=false;
        boolean firstCol=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    if(i==0){
                        firstRow=true;
                    }
                    if(j==0){
                        firstCol=true;
                    }
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i!=0&&j!=0&&(matrix[i][0]==0||matrix[0][j]==0))matrix[i][j]=0;
            }
        }
        
        if(firstRow){
            for(int j=0;j<m;j++){
                matrix[0][j]=0;
            }
        }
        
        if(firstCol){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }
        
        
    }
}