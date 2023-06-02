class Solution {
  public long maximumOr(int[] nums, int k) {
    int n = nums.length;
    long[] left = new long[n];
    long[] right = new long[n];

    long s = 0;

    for (int i = 0; i < n; i++) {
      left[i] = s;
      s |= nums[i];
    }
    s = 0;
    for (int i = n - 1; i >= 0; i--) {
      right[i] = s;
      s |= nums[i];
    }
    long max = 0;

    for (int i = 0; i < n; i++) {
      if (i == 0) {
        max = Math.max(max, (((long)Math.pow(2,k) * nums[i]) | right[i]));
      } else if (i == n - 1) {
        max = Math.max(max, (((long)Math.pow(2,k) * nums[i]) | left[i]));
      } else {
        max = Math.max(max, right[i] | (((long)Math.pow(2,k) * nums[i]) | left[i]));
      }
    }
    return max;

  }
}

/*

10000
00001

*/