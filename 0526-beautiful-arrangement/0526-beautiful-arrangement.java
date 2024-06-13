class Solution {
    Integer[][] dp;
    public int countArrangement(int n) {
        
        dp = new Integer[n+1][(1<<(n+1))];
    
        return dfs(n, 0, 1);
    }
    
    public int dfs(int n, int mask, int index) {
        
        
        
        if(index == n + 1) {
            return 1;
        }
        
        if(dp[index][mask] != null) {
            return dp[index][mask];
        }
        
        int count = 0;
        
        for(int i = 1; i <= n; i++){
            int x = (1<<i);
            
            int bit = (mask&x);
                        
            if(bit == 0) {
                if(i % index == 0 || index % i == 0) {
                    count += dfs(n,(mask|x),index+1);
                }
            }
        }
        return dp[index][mask] = count;
    }
}
// [1,2,3,4,5, 6000]÷






// dp[index][mask]



    