class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph=new ArrayList<>();
        
        
        for(int i=0;i<=n;i++)graph.add(new ArrayList<>());
        
        int[] dp=new int[n+1];
        int[] indegree=new int[n+1];
        
        for(int[] r:relations){
            int u=r[0],v=r[1];
            graph.get(u).add(v);
            indegree[v]++;
        }
        
        
        
        LinkedList<Integer> que=new LinkedList<>();
        
           int ans=0;
        
        for(int i=1;i<n+1;i++){
            if(indegree[i] == 0){
                que.add(i);
                dp[i]=time[i-1];
                ans=Math.max(ans,dp[i]);
                
            }
        }
    
     
        
        while(que.size() !=0){
            int size=que.size();
            while(size-->0){
                int vrtx=que.removeFirst();
                for(int child : graph.get(vrtx)){
                    indegree[child]--;
                    dp[child]=Math.max(dp[child],dp[vrtx]);
                    if(indegree[child]==0){
                        dp[child]=dp[child]+time[child-1];
                        que.add(child);
                    }
                    ans=Math.max(ans,dp[child]);
                }
            }
        }
        
        return ans;
        
    }
}