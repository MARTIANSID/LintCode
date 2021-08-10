import java.util.Arrays;

class Solution{
    static int minCost(int N, int cost[][]) {
        
        int[][] dp=new int[cost.length+1][5];
        for(int[] row:dp)Arrays.fill(row,-1);
        return solve(N,cost,4,0,dp);
    }
    
    public static int solve(int N,int cost[][],int adj,int l,int[][] dp){
        
        if(l==N){
            return dp[l][adj]=0;
        }
        
        if(dp[l][adj]!=-1)return dp[l][adj];
        
        int min=(int)1e9;
        for(int i=0;i<3;i++){
            if(i!=adj){
               min=Math.min(min, solve(N,cost,i,l+1,dp)+cost[l][i]);
                
            }
        }
        
        return dp[l][adj]=min;
        
    }
}