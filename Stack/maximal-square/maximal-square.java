class Solution {
    public int maximalSquare(char[][] matrix) {
        
          
            int max=-(int)1e9;
              int n=matrix.length;
                int m=matrix[0].length;
              int[][] dp=new int[n+1][m+1];
            for(int[] row:dp)Arrays.fill(row,-1);
            for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                            max=Math.max(max,solve(matrix,i,j,dp));
                    }
            }
            
            return max*max;
    }
        public int solve(char[][] matrix,int r,int c,int[][] dp){
                
                int n=matrix.length;
                int m=matrix[0].length;
                
                if(r>=n||c>=m||matrix[r][c]=='0')return dp[r][c]= 0;
                if(dp[r][c]!=-1 )return dp[r][c];
                
               return  dp[r][c]=  1+Math.min(Math.min(solve(matrix,r+1,c+1,dp),solve(matrix,r,c+1,dp)),solve(matrix,r+1,c,dp));  
        }
}