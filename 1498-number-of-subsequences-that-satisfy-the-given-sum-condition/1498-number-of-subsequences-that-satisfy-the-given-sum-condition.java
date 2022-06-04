class Solution {
    int mod = (int) 1e9+7;

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] powerOfTwo = new long[n + 1]; //precomputing power of twos

        powerOfTwo[0] = 1;
        for (int i = 1; i <= n; i++) {
            powerOfTwo[i] = ((powerOfTwo[i - 1]) * 2) % mod;
        }

        int i = 0, j = n - 1;

        long ans = 0;

        while (i <= j) {
            int sum = nums[i] + nums[j];
            if (sum <= target) {
                ans = (ans + powerOfTwo[j - i]) % mod;
                i++;
            } else {
                j--;
            }
        }
        return (int) (ans % mod);
    }
}
