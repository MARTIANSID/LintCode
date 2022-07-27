class Solution {
    Integer[][] dp;
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
        dp=new Integer[n+1][3];
        return solve(nums,0,0);
    }
    
    public int solve(int[] nums,int index,int rem){
        
        
        if(index == nums.length && rem==0)return 0;
        
        if(index==nums.length)return -(int)1e9;
        
        if(dp[index][rem]!=null)return dp[index][rem];
        
        int take=solve(nums,index+1,(rem+nums[index])%3)+nums[index];
        int leave=solve(nums,index+1,rem);
        
        return dp[index][rem]= Math.max(take,leave);
    }
}



// [3,6,5,1,8]
