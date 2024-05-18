class Solution {

    class Edge {
        int node;
        int weight;
        int stops;

        Edge(int node, int weight, int stops) {
            this.weight = weight;
            this.node = node;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Edge>> graph = new ArrayList<>();

        boolean[][] visited = new boolean[n][100];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] t : flights) {
            int u = t[0], v = t[1], w = t[2];
            graph.get(u).add(new Edge(v, w, 0));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(
            (a, b) -> {
                return a.weight - b.weight;
            }
        ); // min heap

        pq.add(new Edge(src, 0, 1));

        while (pq.size() > 0) {
            int size = pq.size();

            while (size-- > 0) {
                Edge e = pq.poll();
                int node = e.node, weight = e.weight, stops = e.stops;
                
                if(visited[node][stops]) continue;

                if (stops - 2 > k) continue;

                if (node == dst) {
                    return weight;
                }

                visited[node][stops] = true;

                for (Edge child : graph.get(node)) {
                    
                    if(!visited[child.node][child.stops+1])
                    pq.add(new Edge(child.node, child.weight + weight, stops + 1));
                }
            }
        }

        return -1;
    }
}
