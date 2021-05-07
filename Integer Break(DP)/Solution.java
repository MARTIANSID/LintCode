class Solution {
    public int integerBreak(int n) {
            int[] dp= new int[n+1];
            Arrays.fill(dp,-1);
        return solve(n,dp,0);
    }
       public int solve(int n,int[] dp,int k){
               if(n==0&&k<2)return 0;
               if(n==0)return dp[n]=1;
               if(dp[n]!=-1)return dp[n];
               int a=0;
               for(int i=1;i<=n;i++){
                  a  =  Math.max(a, solve(n-i,dp,k+1)*i);
               }
               return dp[n]=a;
               
       } 
}