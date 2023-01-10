import java.util.*;

class Solution {
    Long[][] dp;
    int mod = (int) 1e9 + 7;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        dp = new Long[n + 1][k + 1];
        long total = 0;
        for (int ele : nums) {
            total += ele;
        }
        long partitionSumLessThanK = (solve(nums, 0, 0, k, total)) % mod;
        
        

        return (int) ((pow((long)2, (long)n) - partitionSumLessThanK - 2+mod) % mod);
    }

    public long pow(long base, long power) {
        long res = 1;

        while (power > 0) {
            if (power % 2 == 0) {
                base = (base * base) % mod;
                power /= 2;
            } else {
                res = (res * base) % mod;
                power--;
            }
        }
        return res;
    }

    public long solve(int[] nums, int sum, int index, int k, long total) {
        if (sum >= k) return 0;

        if (index == nums.length) {
            if (sum == 0 || sum == total) return 0;
            if (total - sum < k) return 1; 
            else return 2;
        }
        if (dp[index][sum] != null) return dp[index][sum];

        long cnt = 0;
        cnt = (cnt + solve(nums, sum + nums[index], index + 1, k, total)) % mod;
        cnt = (cnt + solve(nums, sum, index + 1, k, total)) % mod;
        return dp[index][sum] = cnt;
    }
}