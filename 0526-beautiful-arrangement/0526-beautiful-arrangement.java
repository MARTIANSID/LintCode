class Solution {
    public int countArrangement(int n) {
    
        return dfs(n, new boolean[n+1], 1);
    }
    
    public int dfs(int n, boolean[] visited, int index) {
        
        if(index == n + 1) {
            return 1;
        }
        
        
        int count = 0;
        
        for(int i = 1; i <= n; i++){
            if(!visited[i]) {
                if(i % index == 0 || index % i == 0) {
                    visited[i] = true;
                    count += dfs(n,visited,index+1);
                    visited[i] = false;
                }
            }
        }
        return count;
    }
}


    