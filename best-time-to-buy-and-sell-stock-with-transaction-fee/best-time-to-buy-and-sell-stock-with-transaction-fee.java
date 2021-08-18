class Solution {
    int solve(int[] arr,int idx,int fee,int flag, int[][] dp) {
        if(idx >= arr.length) return 0;
        if(dp[idx][flag]!=-1) return dp[idx][flag];
        if(flag==0) dp[idx][flag] = Math.max(-arr[idx]+solve(arr,idx+1,fee,1,dp),solve(arr,idx+1,fee,0,dp));
        else return dp[idx][flag] = Math.max(arr[idx]-fee+solve(arr,idx+1,fee,0,dp),solve(arr,idx+1,fee,1,dp));
        return dp[idx][flag];
    }
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return solve(prices,0,fee,0,dp);
    }
}