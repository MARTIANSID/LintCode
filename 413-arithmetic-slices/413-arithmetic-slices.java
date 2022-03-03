class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        if (n == 1 || n == 2) return 0;

        int prev = nums[0] - nums[1];

        dp[1] = 2;

        int ans = 0;

        for (int i = 2; i < n; i++) {
            if (nums[i - 1] - nums[i] == prev) {
                dp[i] = dp[i - 1] + 1;
                if (dp[i] >= 3) ans += (dp[i] - 3) + 1;
            } else {
                prev = nums[i - 1] - nums[i];
                dp[i] = 2;
            }
        }

        return ans;
    }
}
