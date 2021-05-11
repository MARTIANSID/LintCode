public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {

        int[][] dp=new int[costs.length+1][4];

        for(int[] row:dp)Arrays.fill(row,-1);
        
        return solve(costs,costs.length,3,dp);
    }

    public int solve(int[][] costs,int n,int prevColor,int[][] dp){

        if(n==0)return dp[n][prevColor]=0;
    if(dp[n][prevColor]!=-1)return dp[n][prevColor];
        int a=(int)1e9;
        for(int i=0;i<3;i++){
            if(i!=prevColor){
                a= Math.min(a,solve(costs,n-1,i,dp)+costs[n-1][i]);
            }
        }
        return dp[n][prevColor]=a;

    }
}