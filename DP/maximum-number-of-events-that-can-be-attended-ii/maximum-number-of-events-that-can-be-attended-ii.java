class Solution {
    public int maxValue(int[][] events, int k) {
         Arrays.sort(events,(a,b)->{
             return a[0]-b[0];
         });
        int max=0;
        int[][] dp=new int[events.length+1][k+1];
        for(int[] row:dp)Arrays.fill(row,-1);
        for(int i=0;i<events.length;i++){
            max=Math.max(max,solve(events,k-1,i,dp)+events[i][2]);
            
        }
        return max;
    }
    
    public int solve(int[][] events,int k,int index,int[][] dp){
        int max=0;
        
        if(k==0)return 0;
        if(dp[index][k]!=-1)return dp[index][k];
        
        for(int i=index+1;i<events.length;i++){
            if(events[i][0]>events[index][1]){
                max=Math.max(max,solve(events,k-1,i,dp)+events[i][2]);
            }
        }
        return dp[index][k]= max;
        
        
    }
    
}