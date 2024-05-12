class Solution {

    public int findParent(int u, int[] parent) {
        if (u == parent[u]) {
            return u;
        }

        int p = findParent(parent[u], parent);

        return p;
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i; // initial state
        }

        int currentNode = 0;

        for (int[] edges : isConnected) {
            //[1,1,0]

            for (int node = 0; node < edges.length; node++) {
                if (node == currentNode) continue;

                int connection = edges[node];

                if (connection == 1) {
                    // node, currentNode has edge
                    int p1 = findParent(node, parent);
                    int p2 = findParent(currentNode, parent);

                    if (p1 != p2) {
                        parent[p1] = parent[p2]; //adding both node and currentNode in the same set
                    }
                }
            }
            currentNode++;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int p = findParent(i,parent);
            set.add(p);
        }
        return set.size();
    }
}
