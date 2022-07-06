class Solution {

    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        long[] prefix = new long[3 * n];
        long[] suffix = new long[3 * n];

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                return b - a;
            }
        );
        long sum = 0;
        for (int i = 0; i < 3 * n; i++) {
            sum += nums[i];
            if (i < n) {
                pq.add(nums[i]);
                prefix[i] = sum;
            } else {
                pq.add(nums[i]);
                sum -= pq.poll();
                prefix[i] = sum;
            }
        }

        pq = new PriorityQueue<>();
        sum = 0;
        for (int i = 3 * n - 1; i >= 0; i--) {
            sum += nums[i];
            if (3 * n - (i + 1) < n) {
                pq.add(nums[i]);
                suffix[i] = sum;
            } else {
                pq.add(nums[i]);
                sum -= pq.poll();
                suffix[i] = sum;
            }
        }

        long min = (long) 1e11;

        for (int i = n-1; i < 3 * n - (n); i++) {
            min = Math.min(min, prefix[i] - suffix[i + 1]);
        }

        return min;
    }
}
