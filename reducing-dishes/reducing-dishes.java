class Solution {
    Integer[][] dp=new Integer[501][501];
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return solve(0,1,satisfaction);
        
        
    }
    
    public int solve(int index,int time,int[] satisfaction){
        
        if(index==satisfaction.length)return 0;
        if(dp[index][time]!=null)return dp[index][time];
        
        int x=    solve(index+1,time+1,satisfaction)+time*satisfaction[index];
        int y=solve(index+1,time,satisfaction);
        
        return  dp[index][time]= Math.max(x,y);
        
        
    }
}

