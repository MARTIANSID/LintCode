class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        
        int n=matrix.length,m=matrix[0].length,negetiveCount=0,max=(int)1e9,count=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(matrix[i][j]<0){
                    max=Math.min(max,Math.abs(matrix[i][j]));
                    negetiveCount++;
                }else if(matrix[i][j]>0){
                    max=Math.min(max,matrix[i][j]);
                }
                
                sum+=Math.abs(matrix[i][j]);
                if(matrix[i][j]==0)count++;
            }
        }
        if(negetiveCount%2==0)return sum;
        
        
        if(count>0)return sum;
        
        sum-=2*max;
        return sum;
    }
}