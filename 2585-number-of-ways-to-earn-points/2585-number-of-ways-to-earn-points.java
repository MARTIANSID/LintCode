class Solution {
    Long[][] dp;
    int mod=(int)1e9+7;
    public int waysToReachTarget(int target, int[][] types) {
        dp=new Long[target+1][types.length+1];
        return (int)(solve(target,types,0)%mod);
    }
    
    public long solve(int target,int[][] types,int index){
        
        
        if(target<0)return 0;
        
        if(target==0)return 1;
        
        if(index==types.length)return 0;
        
       if(dp[target][index]!=null)return dp[target][index];
        
        int qs=types[index][0],marks=types[index][1];
        long count=0;
        
        for(int i=0;i<=qs;i++){
            count=(count+solve(target-i*marks,types,index+1))%mod;
        }
        return  dp[target][index]=count;
    }
}