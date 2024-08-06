class Solution {

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            set.add(i);
        }

        int[] ans = new int[queries.length];

        int index = 0;

        for (int[] q : queries) {
            int u = q[0], v = q[1];

            int upperBound = set.higher(u);

            if (!set.contains(u) || !set.contains(v)) {
                ans[index++] = set.size() - 1;
                continue;
            }

            while (upperBound != v) {
                set.remove(upperBound);
                upperBound = set.higher(upperBound);
            }
            ans[index++] = set.size() - 1;
        }

        return ans;
    }
}
// q1 = [a,b]
// q2 = [c,d]
// a < c < b < d
// There are no two queries such that queries[i][0] < queries[j][0] < queries[i][1] < queries[j][1].
// 0       5   9
// 5 - > 9   [5,9] - q2
// x1*log(n) + x2*log(n) + x3*log(n) - > log(n)*(n)
