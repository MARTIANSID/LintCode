class Solution {

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] temp = new int[n];

        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < n; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
            temp[i] = nums2[i] - nums1[i];
        }

        int globalMax = 0, globalMin = 0, currMin = 0, currMax = 0;

        for (int i = 0; i < n; i++) {
            currMax = Math.max(temp[i], temp[i] + currMax);
            globalMax = Math.max(globalMax, currMax);
        }
        for (int i = 0; i < n; i++) {
            currMin = Math.min(temp[i], temp[i] + currMin);
            globalMin = Math.min(globalMin, currMin);
        }

        return Math.max(sum1 + globalMax, sum2 - globalMin);
    }
}
