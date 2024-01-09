class Solution {
    Integer[][] dp;

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        dp = new Integer[nums.size() + 1][target + 1];

        int ans = solve(nums, target, 0);
        
        return ans < 0 ? -1 : ans;
    }

    public int solve(List<Integer> nums, int target, int index) {
        if (target == 0) return 0;

        if (index == nums.size()) return -(int) 1e9;

        if (dp[index][target] != null) return dp[index][target];

        int max = -(int)1e9;

        if (target - nums.get(index) >= 0) max = solve(nums, target - nums.get(index), index + 1) + 1;
        max = Math.max(max, solve(nums, target, index + 1));

        return dp[index][target] = max;
    }
}
