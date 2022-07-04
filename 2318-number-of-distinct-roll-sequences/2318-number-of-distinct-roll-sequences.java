class Solution {
    Long[][][] dp;
    int mod = (int) 1e9 + 7;

    public int distinctSequences(int n) {
        dp = new Long[n + 1][14][14];

        return (int) (solve(n, 13, 0) % mod);
    }

    public long solve(int n, int prev1, int prev2) {
        if (n == 0) {
            return 1;
        }
        long count = 0;

        if (dp[n][prev1][prev2] != null) return dp[n][prev1][prev2];

        for (int i = 1; i <= 6; i++) {
            if (gcd(prev1, i) == 1 && i != prev2 && i != prev1) {
                count = (count + solve(n - 1, i, prev1)) % mod;
            }
        }
        return dp[n][prev1][prev2] = count;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
