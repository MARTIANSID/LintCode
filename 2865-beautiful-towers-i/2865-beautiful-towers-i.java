class Solution {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();

        long sum = 0, max = 0;

        for (int i = 0; i < n; i++) {
            sum = (long) maxHeights.get(i);
            int cur = maxHeights.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (maxHeights.get(j) <= cur) {
                    sum += maxHeights.get(j);
                    cur = maxHeights.get(j);
                } else {
                    sum += cur;
                }
            }

            cur = maxHeights.get(i);
            for (int j = i + 1; j < n; j++) {
                if (maxHeights.get(j) <= cur) {
                    sum += maxHeights.get(j);
                    cur = maxHeights.get(j);
                } else {
                    sum += cur;
                }
            }
            max = Math.max(max, sum);
        }

        return max;
    }
}
