class Solution {

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] ans = new int[k][k];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < rowConditions.length; i++) {
            graph.get(rowConditions[i][0]).add(rowConditions[i][1]);
        }
        List<Integer> rowSorted = topoSort(graph, k);

        graph.clear();
        for (int i = 0; i <= k; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < colConditions.length; i++) {
            graph.get(colConditions[i][0]).add(colConditions[i][1]);
        }

        List<Integer> colSorted = topoSort(graph, k);
        if (rowSorted.size() < k || colSorted.size() < k) return new int[][] {};

        HashMap<Integer, Integer> col = new HashMap<>();
        HashMap<Integer, Integer> row = new HashMap<>();
        int index = 0;
        for (int ele : rowSorted) {
            row.put(ele, index++);
        }
        index = 0;
        for (int ele : colSorted) {
            col.put(ele, index++);
        }
        for (int i = 1; i <= k; i++) {
            ans[row.get(i)][col.get(i)] = i;
        }
        return ans;
    }

    public List<Integer> topoSort(List<List<Integer>> graph, int k) {
        int[] indegree = new int[k + 1];

        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= k; i++) {
            List<Integer> arr = graph.get(i);
            for (int ele : arr) {
                indegree[ele]++;
            }
        }

        LinkedList<Integer> que = new LinkedList<>();

        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int vrtx = que.removeFirst();
                ans.add(vrtx);
                for (int child : graph.get(vrtx)) {
                    indegree[child]--;
                    if (indegree[child] == 0) que.add(child);
                }
            }
        }
        return ans;
    }
}
