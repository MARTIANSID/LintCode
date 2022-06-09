class Solution {

    public int findParent(int[] parent, int u) {
        if (parent[u] == u) {
            return u;
        }
        int x = findParent(parent, parent[u]);
        parent[u] = x;
        return x;
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int m = queries.length;

        int[][] q = new int[m][4];

        int[] parent = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = queries[i][2];
            q[i][3] = i;
        }

        Arrays.sort(
            edgeList,
            (a, b) -> {
                return a[2] - b[2];
            }
        );

        Arrays.sort(
            q,
            (a, b) -> {
                return a[2] - b[2];
            }
        );

        int index = 0;

        boolean[] ans = new boolean[m];

        int max = 0;

        for (int[] e : edgeList) {
            int w = e[2], u = e[0], v = e[1];
            max = w;

            int p1 = findParent(parent, u);
            int p2 = findParent(parent, v);

            if (p1 != p2) {
                while (index < m && q[index][2] <= w) {
                    if (findParent(parent, q[index][0]) == findParent(parent, q[index][1])) {
                        ans[q[index][3]] = true;
                    }
                    index++;
                }

                parent[p1] = p2;

                if (index < m) {
                    if (findParent(parent, q[index][0]) == findParent(parent, q[index][1])) {
                        ans[q[index][3]] = true;
                        index++;
                    }
                }
            }
        }

        while (index < m) {
            if (findParent(parent, q[index][0]) == findParent(parent, q[index][1])) {
                ans[q[index][3]] = true;
            }
            index++;
        }

        return ans;
    }
}
