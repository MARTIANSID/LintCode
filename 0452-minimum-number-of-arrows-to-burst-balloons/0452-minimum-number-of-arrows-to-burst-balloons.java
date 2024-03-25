class Solution {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(
            points,
            (a, b) -> {
                return Integer.compare(a[0], b[0]);
            }
        );

        int start = points[0][0], end = points[0][1], cnt = 0, n = points.length;

        for (int i = 1; i < n; i++) {
            int[] point = points[i];

            int s = point[0], e = point[1];

            if (end < s) {
                cnt++;
                end = e;
            } else {
                end = Math.min(end, e);
            }
        }

        return cnt + 1;
    }
}
// [[1,6],[2,8],[7,12],[1,16]]
