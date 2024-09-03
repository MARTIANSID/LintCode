class Solution {

    public int[] resultsArray(int[][] queries, int k) {
        int n = queries.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                return b - a;
            }
        );

        int[] ans = new int[n];

        int i = 0;

        for (int[] q : queries) {
            int x = q[0], y = q[1];

            int dist = Math.abs(x) + Math.abs(y);

            pq.add(dist);
            
            if(pq.size() < k) {
                ans[i++] = -1;
                continue;
            }

            if (pq.size() > k) {
                pq.poll();
            }
            
            
            ans[i++] = pq.peek();
        }
        return ans;
    }
}
