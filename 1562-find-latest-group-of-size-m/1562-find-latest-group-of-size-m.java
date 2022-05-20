class Solution {

    public int findParent(int[] parent, int u) {
        if (parent[u] == u) return u;

        int x = findParent(parent, parent[u]);
        parent[u] = x;
        return x;
    }

    public void union(int p1, int p2, int[] count, int[] size, int[] parent) {
        if (p1 != p2) {
            parent[p1] = p2;
            count[size[p2]]--;
            count[size[p1]]--;
            size[p2] += size[p1];
            count[size[p2]]++;
        }
    }

    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;

        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;
        int[] size = new int[n + 1];
        Arrays.fill(size, 1);
        int[] bits = new int[n + 1];
        int[] count = new int[n + 1];

        int steps = 1, ans = -1;

        for (int i = 0; i < n; i++) {
            int index = arr[i] - 1;
            bits[index] = 1;

            boolean flag = false;

            if (index + 1 < n && bits[index + 1] == 1) {
                flag = true;
                union(index, findParent(parent, index + 1), count, size, parent);
            }
            if (index - 1 >= 0 && bits[index - 1] == 1) {
                flag = true;
                union(findParent(parent, index), findParent(parent, index - 1), count, size, parent);
            }

            count[1]++;

            if (count[m] > 0) {
                ans = steps;
            }
            steps++;
        }
        return ans;
    }
}
