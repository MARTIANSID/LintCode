class Solution {
    int cnt = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i <n; i++){
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(graph, n - 1, -1, k, values);

        return cnt;
    }

    public int dfs(List<List<Integer>> graph, int src, int par, int k, int[] values) {
        int sum = 0;
        for (int child : graph.get(src)) {
            if (child != par) {
                sum += dfs(graph, child, src, k, values);
            }
        }
        sum += (values[src]);
        
        sum = sum % k;
        
        if (sum % k == 0) {
            cnt++;
        }
            return sum;
    }
}
