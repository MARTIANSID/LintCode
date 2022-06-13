class Solution {
    int[] ans;

    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        ans = new int[n];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        HashMap<Integer, List<int[]>> map = new HashMap<>();
        dfs(graph, 0, -1, nums, map, 0);

        return ans;
    }

    public void dfs(List<List<Integer>> graph, int src, int parent, int[] nums, HashMap<Integer, List<int[]>> map, int level) {
        Set<Integer> set = map.keySet();

        int max = -1, node = -1;
        for (int key : set) {
            if (gcd(key, nums[src]) == 1) {
                if (map.get(key).size() != 0) {
                    int[] l = map.get(key).get(map.get(key).size() - 1);
                    if (l[1] > max) {
                        max = l[1];
                        node = l[0];
                    }
                }
            }
        }

        ans[src] = node;

        map.putIfAbsent(nums[src], new ArrayList<>());
        map.get(nums[src]).add(new int[] { src, level });

        for (int child : graph.get(src)) {
            if (child == parent) continue;
            dfs(graph, child, src, nums, map, level + 1);
        }

        map.get(nums[src]).remove(map.get(nums[src]).size() - 1);
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }
}
