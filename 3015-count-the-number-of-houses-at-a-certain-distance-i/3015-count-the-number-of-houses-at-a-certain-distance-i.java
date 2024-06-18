class Solution {

    public int[] countOfPairs(int n, int x, int y) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 2; i <= n; i++) {
            int u = i - 1, v = i;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        graph.get(x).add(y);
        graph.get(y).add(x);

        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            LinkedList<Integer> que = new LinkedList<>();
            que.add(i);

            int level = 0;

            boolean[] visited = new boolean[n + 1];

            while (que.size() > 0) {
                int size = que.size();

                while (size-- > 0) {
                    int houseNo = que.removeFirst();

                    if (visited[houseNo]) {
                        continue;
                    }
                    visited[houseNo] = true;

                    map.putIfAbsent(i, new int[n + 1]);

                    map.get(i)[houseNo] = level;

                    for (int child : graph.get(houseNo)) {
                        if (!visited[child]) {
                            que.add(child);
                        }
                    }
                }
                level++;
            }
        }

        int[] ans = new int[n];

        Set<Integer> keySet = map.keySet();

        for (int houseNo : keySet) {
            int[] distance = map.get(houseNo);
            // System.out.println(Arrays.toString(distance));

            for (int i = 1; i < distance.length; i++) {
                if (i != houseNo) ans[distance[i]-1]++;
            }
        }
        return ans;
    }
}
// {
//     1 : [0,0]
//     2 : [0,0]
//     3 : [0,0]
// }
// [ [2,3], [1,3], [1,2]  ]
