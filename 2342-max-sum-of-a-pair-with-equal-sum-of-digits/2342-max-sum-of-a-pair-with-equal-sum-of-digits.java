class Solution {

    public int maximumSum(int[] nums) {
        int n = nums.length, max = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i], sum = 0;

            while (num != 0) {
                int temp = num % 10;
                sum += temp;
                num /= 10;
            }
            if (map.containsKey(sum)) {
                max = Math.max(max, nums[i] + map.get(sum));

                map.put(sum, Math.max(nums[i], map.get(sum)));
            } else {
                map.put(sum, nums[i]);
            }
        }

        // System.out.println(map);
        return max;
    }
}
