class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        // int[] dp = new int[n];

        if (n == 1 || n == 2) return 0;

        int prev = nums[0] - nums[1];

        int dp = 2;
        
        

        int ans = 0;

        for (int i = 2; i < n; i++) {
            if (nums[i - 1] - nums[i] == prev) {
                dp = dp + 1;
                if (dp >= 3) ans += (dp - 3) + 1;
            } else {
                prev = nums[i - 1] - nums[i];
                dp = 2;
            }
        }

        return ans;
    }
}
