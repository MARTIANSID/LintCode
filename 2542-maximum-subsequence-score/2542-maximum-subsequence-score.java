class Solution {

    class pair {
        int index;
        int val;

        pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        long max = 0, sum = 0;

        pair[] sortedNums2 = new pair[n];

        for (int i = 0; i < n; i++) {
            sortedNums2[i] = new pair(i, nums2[i]);
        }

        Arrays.sort(
            sortedNums2,
            (a, b) -> {
                return b.val - a.val;
            }
        );

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pair p = sortedNums2[i];
            sum += nums1[p.index];

            if (i >= k) {
                int val = pq.poll();
                sum -= val;
            }

            pq.add(nums1[p.index]);

            if (i >= k - 1) max = Math.max(max, p.val * sum);
        }
        return max;
    }
}
// [1,2,3,4]
