class Solution {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<HashSet<Integer>> ancestors = new ArrayList<>();

        List<List<Integer>> graph = new ArrayList<>();

        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            ancestors.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            graph.get(u).add(v);
            indegree[v]++;
        }

        LinkedList<Integer> que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }

        while (que.size() != 0) {
            int size = que.size();

            while (size-- > 0) {
                int node = que.removeFirst();

                for (int child : graph.get(node)) {
                    ancestors.get(child).add(node);

                    for (int ansc : ancestors.get(node)) {
                        ancestors.get(child).add(ansc);
                    }
                    indegree[child]--;

                    if (indegree[child] == 0) {
                        que.add(child);
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (HashSet<Integer> set : ancestors) {
            List<Integer> temp = new ArrayList<>(set);
            Collections.sort(temp);
            ans.add(temp);
        }

        return ans;
    }
}
