class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
            int[][] dp=new int[matrix.length+1][matrix[0].length+1];
            
            for(int[] row:dp)Arrays.fill(row,-1);
            
            int max=0;
            for(int i=0;i<matrix.length;i++){
                    for(int j=0;j<matrix[0].length;j++){
                            if(dp[i][j]!=-1)continue;
                            max=Math.max(max,solve(matrix,i,j,dp));
                    }
            }
            
            return max+1;
    }
        public int solve(int[][] matrix,int row,int col,int[][] dp){
                
                
                
                
                
               int up=0;
                int down=0;
                int left=0;
                int right=0;
                
                if(dp[row][col]!=-1)return dp[row][col];
                
                
        if(row+1<matrix.length&&matrix[row+1][col]>matrix[row][col])
        up=  solve(matrix,row+1,col,dp)+1;
                  if(row-1>=0&&matrix[row-1][col]>matrix[row][col])
              down=    solve(matrix,row-1,col,dp)+1;      
  if(col+1<matrix[0].length&&matrix[row][col+1]>matrix[row][col])
                     right=     solve(matrix,row,col+1,dp)+1;    
                
                
                  if(col-1>=0&&matrix[row][col-1]>matrix[row][col])
                        left=solve(matrix,row,col-1,dp)+1;     
                
                
                return dp[row][col]= Math.max(Math.max(up,down),Math.max(left,right));

        
        }
}