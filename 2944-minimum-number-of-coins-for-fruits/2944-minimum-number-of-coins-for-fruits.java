class Solution {
    Integer[] dp;
    public int minimumCoins(int[] prices) {
        
        dp = new Integer[prices.length];
        
        return solve(prices,0);
    }
    
    public int solve(int[] prices,int index){
        
        if(index>=prices.length) return 0;
        
        if(dp[index] != null) return dp[index];
        
        int min = (int)1e9;
        for(int i=index+1;i<=(2*index+2);i++){
            min=Math.min(min,solve(prices,i)+prices[index]);
        }
        return dp[index] = min;
        
    }
}