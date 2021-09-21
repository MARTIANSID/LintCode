import java.util.*;

class Solution {
    // Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int v, ArrayList<ArrayList<Integer>> graph) {
        Stack<Integer> st = new Stack<>();
        int n = graph.size();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < v; i++)
            if (!visited[i])
                dfs(graph, visited, st, i);

        int candidate = st.pop();
        ;

        st.clear();

        visited = new boolean[n];

        dfs(graph, visited, st, candidate);

        if (st.size() == v)
            return candidate;
        return -1;

    }

    public void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> st, int src) {

        visited[src] = true;

        for (int child : graph.get(src)) {
            if (visited[child] != true) {
                dfs(graph, visited, st, child);
            }
        }
        st.push(src);

    }
}