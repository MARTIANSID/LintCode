class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int maxArea=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int[] temp=new int[m];
        for(int i=0;i<n;i++){
            int[] sorted=new int[m];
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0)temp[j]=0;
                else temp[j]+=1;
            }
            for(int k=0;k<m;k++)sorted[k]=temp[k];
            Arrays.sort(sorted);
            for(int k=m-1;k>=0;k--){
                maxArea=Math.max(maxArea,(m-k)*sorted[k] );
            }
        }
        return maxArea;
    }
}