class Solution {

    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length, max = -(int)1e9;

        int[] dp = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = energy[i] + ((i + k) >= n ? 0 : dp[i + k]);

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
// k = 3
// 0  1  2  3  4
// [5,2,-10,-5,1]  3 + 3
// dp[4] = 1
// dp[3] = -5
// dp[2] = -10
// dp[1] = 2 + dp[4] = 3
// dp[0] = 5 + dp[3] = 0
// tc  - O(n)
