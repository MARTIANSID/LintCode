class Solution {
        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

                ArrayList<ArrayList<Integer>> tree = new ArrayList<>(n);

                for (int i = 0; i < n; i++) {
                        tree.add(new ArrayList<>());
                }

                for (int i = 0; i < edges.length; i++) {

                        int u = edges[i][0];
                        int v = edges[i][1];
                        tree.get(u).add(v);
                        tree.get(v).add(u);
                }

                int x = dfs(tree, 0, -1, hasApple);
                return x == 0 ? 0 : (x - 1) * 2;
                // return (dfs(tree,0,-1,hasApple)==?-1)*2;

        }

        public int dfs(ArrayList<ArrayList<Integer>> tree, int src, int parent, List<Boolean> hasApple) {

                int x = 0;
                for (int child : tree.get(src)) {
                        if (parent != child)
                                x += dfs(tree, child, src, hasApple);

                }

                if (hasApple.get(src) || x > 0) {
                        x++;
                }

                return x;

        }

}