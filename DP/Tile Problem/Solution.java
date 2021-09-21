
class Solution {
    Long[] dp;
    int mod = (int) 1e9 + 7;

    public int countWays(int n, int m) {
        dp = new Long[n + 1];
        return (int) (solve(n, m) % mod);
    }

    public long solve(int n, int m) {

        if (n == 0)
            return 1;

        if (m > n)
            return 1;

        if (dp[n] != null)
            return dp[n];

        long count = 0;
        if (n - 1 >= 0)
            count = (count + solve(n - 1, m)) % mod;
        if (n - m >= 0)
            count = (count + solve(n - m, m)) % mod;
        return dp[n] = count;
    }
}