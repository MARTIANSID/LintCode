class Solution {
    public int minFallingPathSum(int[][] arr) {
            int min=(int)1e9;
            int[][] dp=new int[arr.length+1][arr[0].length+1];
            for(int[] row:dp)Arrays.fill(row,-1);
       for(int i=0;i<arr[0].length;i++){
               min=Math.min(min,solve(arr,0,i,dp));
       }
            return min;
    }
        
        public int solve(int[][] arr, int r,int c,int[][] dp){
                
                if(r>=arr.length||c>=arr[0].length)return dp[r][c]=(int)1e9;
                
                if(r==arr.length-1){
                        return arr[r][c];
                }
                
                if(dp[r][c]!=-1)return dp[r][c];
                
                int min=(int)1e9;
                for(int i=0;i<arr[0].length;i++){
                        if(i!=c)
                    min=   Math.min(min, solve(arr,r+1,i,dp)+arr[r][c]);
                }
                return  dp[r][c]=min;
        }
}