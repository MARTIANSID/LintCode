class Solution {
    Integer[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        
        dp=new Integer[n];
        
        solve(0,cost,n);
        
        return Math.min(dp[0],dp[1]);
    }
    
    public int solve(int index,int[] cost,int n){
        
        
        if(index>=n)return  0;
        
        if(dp[index]!=null)return dp[index];  
        
      int oneStep=  solve(index+1,cost,n);
        
     int twoStep=   solve(index+2,cost,n);
        int val= Math.min(oneStep,twoStep)+cost[index];
     dp[index]=   val;
        return val;
    }
}