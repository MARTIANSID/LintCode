class Solution {
    public int tallestBillboard(int[] rods) {
            
         int[][] dp=new int[rods.length+1][10001];   
            for(int[] row:dp)Arrays.fill(row,-1);
     return solve(rods,0,0,dp);
           
    }
        public int solve(int[] rods,int i,int left,int[][] dp){
        if(i==rods.length){
                if(left==0) return dp[i][left+5000]= 0;
                else return  dp[i][left+5000]= -(int)1e9;
        }
                
                if( dp[i][left+5000]!=-1)return  dp[i][left+5000];
                
                
         return  dp[i][left+5000]= Math.max(   rods[i]+  solve(rods,i+1,left+rods[i],dp),Math.max(solve(rods,i+1,left-rods[i],dp),solve(rods,i+1,left,dp)));
        }
}