class Solution {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length, m = l.length;

        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int left = l[i], right = r[i];

            if ((right - left + 1) <= 1) {
                ans.add(false);
                continue;
            }

            int[] result = new int[right - left + 1];

            int index = 0;

            for (int j = left; j <= right; j++) {
                result[index++] = nums[j];
            }

            Arrays.sort(result);

            boolean flag = false;

            int prev = result[0] - result[1];

            for (int k = 2; k < result.length; k++) {
                if (result[k - 1] - result[k] != prev) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                ans.add(false);
            } else {
                ans.add(true);
            }
        }

        return ans;
    }
}
