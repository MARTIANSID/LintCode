class Solution {

    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];

        int components = 0;
        long ans=0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int size=dfs(graph, visited, i)+1;
                ans=ans+(long)((long)components*(long)size);
                components+=size;
                
            }
        }
        return ans;
    }

    public int dfs(List<List<Integer>> graph, boolean[] visited, int src) {
        visited[src] = true;
        int count=0;
        for(int child:graph.get(src)){
            if(!visited[child]){
                count+=dfs(graph,visited,child)+1;
            }
        }
        return count;
    }
}
