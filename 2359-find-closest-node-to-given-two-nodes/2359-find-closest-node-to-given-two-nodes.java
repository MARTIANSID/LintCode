class Solution {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) graph.get(i).add(edges[i]);
        }
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        Arrays.fill(dist1, (int) 1e9);
        Arrays.fill(dist2, (int) 1e9);

        int min = (int) 1e9, index = -1;

        bfs(graph, dist1, node1);
        bfs(graph, dist2, node2);

        for (int i = 0; i < n; i++) {
            int val = Math.max(dist1[i], dist2[i]);
            if (val < min) {
                index = i;
                min = val;
            }
        }
        return index;
    }

    public void bfs(List<List<Integer>> graph, int[] dist, int src) {
        int n = dist.length;
        boolean[] visited = new boolean[n];
        LinkedList<Integer> que = new LinkedList<>();
        que.add(src);
        int level = 0;
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int vrtx = que.removeFirst();
                if (visited[vrtx]) continue;
                dist[vrtx] = level;
                visited[vrtx] = true;
                for (int child : graph.get(vrtx)) {
                    if (!visited[child]) {
                        que.add(child);
                    }
                }
            }
            level++;
        }
    }
}
