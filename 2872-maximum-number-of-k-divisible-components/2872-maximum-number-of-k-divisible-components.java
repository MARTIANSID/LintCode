class Solution {
    int noOfComponents = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        long sum = dfs(graph, n - 1, values, -1, k);

        if (sum % k == 0) {
            noOfComponents++;
        }

        return noOfComponents;
    }

    public long dfs(List<List<Integer>> graph, int src, int[] values, int par, int k) {
        long sum = 0;

        for (int child : graph.get(src)) {
            if (child != par) {
                long sumOfChildValues = dfs(graph, child, values, src, k);

                if (sumOfChildValues % k == 0) {
                    noOfComponents += 1;
                } else {
                    sum += sumOfChildValues;
                }
            }
        }
        return sum + values[src];
    }
}
