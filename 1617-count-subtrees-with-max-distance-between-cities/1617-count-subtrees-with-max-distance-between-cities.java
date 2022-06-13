class Solution {
    int mask = 0;
    int om = 0;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        /*
            Algo
            1.Generate all subsets
            2.find out the diameter (this will give us the max distance btw any two nodes)  
        */

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];
        int[] ans = new int[n - 1];

        for (int i = 0; i <= (1 << n); i++) {
            for (int j = 1; j <= n; j++) {
                int x = (1 << (j - 1));
                int bit = (i & x) == 0 ? 0 : 1;
                if (bit == 1) {
                    dfs(graph, j, -1, i);
                    break;
                }
            }

            if (mask == i) {
                if (om != 0) {
                    ans[om - 1]++;
                }
            }
            mask = 0;
            om = 0;
        }
        return ans;
    }

    public int dfs(List<List<Integer>> graph, int src, int parent, int m) {
        mask |= ((1 << (src - 1)));

        int mx = 0, smx = 0;
        for (int child : graph.get(src)) {
            if (child == parent) continue;
            int x = (1 << (child - 1));
            int bit = (m & x) == 0 ? 0 : 1;
            if (bit == 1) {
                int val = dfs(graph, child, src, m);
                if (val > mx) {
                    smx = mx;
                    mx = val;
                } else if (val > smx) {
                    smx = val;
                }
            }
        }

        om = Math.max(om, smx + mx);
        return mx + 1;
    }
}
