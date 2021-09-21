class Solution
{
    Long[] dp;
    int mod=(int)1e9+7;
    long countWays(int n,int k)
    {
        dp=new Long[n];
        if(n==1)return k;
      
        return (k*(solve(n-1,k)+solve(n-2,k)))%mod; 
    }
    
    public long solve(int n,int k){
        
        if(n==0)return 1;
        
        if(dp[n]!=null)return dp[n];
        
       long count=0;
       count=(count+(k-1)*solve(n-1,k))%mod;
       if(n-2>=0)
       count=(count+(k-1)*solve(n-2,k))%mod;
       
       return  dp[n]= count;
        
    }
}
