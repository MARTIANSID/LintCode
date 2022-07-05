class Solution {
    int min = (int) 1e9;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int totalXor = dfs(graph, 0, -1, -1, nums);

        //logic break one edge
        //now get xor of the each subtree
        //now get all xor each subtree in both of these components

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            int xorComp1 = dfs(graph, u, v, -1, nums);
            int xorComp2 = xorComp1 ^ totalXor;
            solve(graph, u, v, -1, nums, xorComp1, xorComp2);
            solve(graph, v, u, -1, nums, xorComp2, xorComp1);
           
        }
        return min;
    }

    public int dfs(List<List<Integer>> graph, int src, int v, int par, int[] nums) {
        int xor = 0;
        for (int child : graph.get(src)) {
            if (child != par && child != v) {
                xor ^= dfs(graph, child, v, src, nums);
            }
        }
        return xor ^ nums[src];
    }

    public int solve(List<List<Integer>> graph, int src, int v, int par, int[] nums, int xorComp1, int xorComp2) {
        int xor = 0;
        for (int child : graph.get(src)) {
            if (child != par && child != v) {
                int val = solve(graph, child, v, src, nums, xorComp1, xorComp2);
                xor^=val;
                int rem = (xorComp1 ^ val);
                min = Math.min(min, Math.max(rem, Math.max(val, xorComp2)) - Math.min(rem, Math.min(val, xorComp2)));
            }
        }
        return xor ^ nums[src];
    }
}
