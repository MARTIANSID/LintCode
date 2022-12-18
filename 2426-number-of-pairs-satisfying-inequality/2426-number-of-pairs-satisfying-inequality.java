class Solution {
  long cnt = 0;

  public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
    int n = nums1.length;
    int[] nums = new int[n];

    for (int i = 0; i < n; i++) {
      nums[i] = nums1[i] - nums2[i];
    }
    int[] sorted=solve(nums, diff, 0, n - 1);
    // System.out.println(Arrays.toString(sorted));

    return cnt;
  }

  public int[] solve(int[] nums, int diff, int si, int ei) {

    if(ei==si){
      return new int[]{nums[si]};
    }

    int mid = (si + ei) / 2;
    int[] left = solve(nums, diff, si, mid);
    int[] right = solve(nums, diff, mid + 1, ei);

    int n1 = left.length, n2 = right.length;
    int i = 0, j = 0;
    while (i < n1 && j < n2) {
      int val = left[i] - right[j];
      if (val <= diff) {
        i++;
        cnt += (n2 - j);
      } else {
        j++;
      }
    }
    return mergeArrays(left, right,left.length,right.length,new int[left.length+right.length]);

  }

  public static int[] mergeArrays(int[] arr1, int[] arr2, int n1,
      int n2, int[] arr3) {
    int i = 0, j = 0, k = 0;
    while (i < n1 && j < n2) {
      if (arr1[i] < arr2[j])
        arr3[k++] = arr1[i++];
      else
        arr3[k++] = arr2[j++];
    }

    while (i < n1)
      arr3[k++] = arr1[i++];

    while (j < n2)
      arr3[k++] = arr2[j++];
      return arr3;
  }
}