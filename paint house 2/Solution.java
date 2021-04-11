
public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        // write your code here
        if(costs.length==0)return 0;
    int[][] dp=new int[costs.length+1][costs[0].length+3];
    int n=costs.length;
    for(int[] row:dp)Arrays.fill(row,-1);
        return solve(costs,n,costs[0].length+2,dp);
    }

    public int solve(int[][] costs,int n,int prevColor,int[][] dp){

        if(n==0)return dp[n][prevColor]=0;
    if(dp[n][prevColor]!=-1)return dp[n][prevColor];
        int a=(int)1e9;
        for(int i=0;i<costs[0].length;i++){
            if(i!=prevColor){
                a= Math.min(a,solve(costs,n-1,i,dp)+costs[n-1][i]);
            }
        }
        return dp[n][prevColor]=a;

    }
}