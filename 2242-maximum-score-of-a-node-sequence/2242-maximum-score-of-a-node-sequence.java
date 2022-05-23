class Solution {

    public int maximumScore(int[] scores, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = scores.length;

        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(
                graph.get(i),
                (a, b) -> {
                    return scores[b] - scores[a];
                }
            );
        }

        int max = 0;

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            int sum = scores[u] + scores[v];
            for (int i=0;i<Math.min(3,graph.get(u).size());i++) {
                int childU=graph.get(u).get(i);
                if (childU == v) continue;

                for (int j=0;j<Math.min(3,graph.get(v).size());j++) {
                     int childV=graph.get(v).get(j);
                    if (childV == u || childV == childU) continue;

                    max = Math.max(max, sum + scores[childV] + scores[childU]);
                }
               
            }
        }
        return max == 0?-1:max;
    }
}
