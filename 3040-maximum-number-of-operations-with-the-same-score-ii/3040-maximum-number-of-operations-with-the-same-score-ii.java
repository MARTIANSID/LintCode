class Solution {
    Integer[][] dp;
    public int maxOperations(int[] nums) {
        
        int n = nums.length;
        
        dp = new Integer[n][n];
            
        return solve(nums,0,n-1,-1);
        
    }
    
    public int solve(int[] nums,int i,int j,int prev) {
        if(i>=j) return 0;
        
        int max = 0;
        
        if(dp[i][j]!=null) return dp[i][j];
        
        if(prev == -1 || nums[i]+nums[i+1] == prev)
        max = Math.max(max,1+solve(nums,i+2,j,nums[i]+nums[i+1]));
        
         if(prev == -1 || nums[j]+nums[j-1] == prev)
        max = Math.max(max,1+solve(nums,i,j-2,nums[j]+nums[j-1]));
        
        
         if(prev == -1 || nums[i]+nums[j] == prev)
        max = Math.max(max,1+solve(nums,i+1,j-1,nums[i]+nums[j]));
        
        return dp[i][j] = max;
        
            
            
    }
}

/*
why prev is not part of the dp?

because when we arrive at the same state then the total sum of removed pairse will be same and the no of pairs removed will also be the same for each state and hence the sum of each pair = total sum / no of pairs will also be same as result


*/