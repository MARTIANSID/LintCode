class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        
        int[] dp = new int[n];
        
        for(int i = n - 2; i >= 0; i--) {
            dp[i] = (int)1e9;
        }
        
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n - 1; i++) {            
            graph.get(i).add(i+1);
        }
        
        int[] ans = new int[queries.length];    
        
        int index = 0;
        
        for(int[] query: queries) {
            int u = query[0], v = query[1];
            graph.get(u).add(v);
            
            for(int i = n-2; i >= 0; i--) {
                List<Integer> directlyConnectedNodes = graph.get(i);
                
                for(int node : directlyConnectedNodes) {
                    dp[i] = Math.min(dp[i],dp[node] + 1);
                }
            }
            ans[index++] = dp[0];
        }
        return ans;
    }
}