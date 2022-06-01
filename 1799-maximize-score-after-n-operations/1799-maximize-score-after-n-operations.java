class Solution {
    
    
    Integer[][] dp;
    
    public int maxScore(int[] nums) {
        int n = nums.length;
        
        dp=new Integer[n/2+1][1<<n];
        
        return solve(nums, 0, 0);
    }

    public int solve(int[] nums, int opt, int mask) {
        int n = nums.length;
        int operations=n/2;

        if (opt == operations) {
            return 0;
        }
        
        if(dp[opt][mask]!=null)return dp[opt][mask];

        int max = 0;
        
      

        for (int i = 0; i < n; i++) {
            
            if ((mask & (1 << i)) == 0) {
                for (int j = i + 1; j < n; j++) {
                    if ((mask & (1 << j)) == 0) {
                        int val = ((1 << i) | (1 << j));
                        max = Math.max(max, ((opt + 1) * gcd(nums[i], nums[j]) + solve(nums, opt + 1, (mask | val))));
                    }
                }
            }
        }
        return dp[opt][mask]= max;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }
}
