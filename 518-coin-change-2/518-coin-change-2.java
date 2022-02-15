class Solution {

    public int change(int amount, int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 1][amount + 1];

        for (int i = n; i >= 0; i--) {
            for (int j = 0; j <= amount; j++) {
                if (i == n && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                if (i == n) {
                    dp[i][j] = 0;
                    continue;
                }

                int dontTake = dp[i + 1][j];

                int take = 0;

                if (j - nums[i] >= 0) take = dp[i][j - nums[i]];

                dp[i][j] =take+dontTake;
            }
        }
        
        return dp[0][amount];
    }


}
