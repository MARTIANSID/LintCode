class Solution {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int i = 0, j = n - 1;
        int index = n - 1;
        while (i <= j) {
            int max1 = nums[i] * nums[i], max2 = nums[j] * nums[j];

            if (i == j) {
                ans[index] = max1;
                return ans;
            }

            if (max2 > max1) {
                ans[index] = max2;
                j--;
            } else {
                ans[index] = max1;
                i++;
            }
            index--;
        }

        return ans;
    }
}
