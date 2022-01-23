class Solution {
    Integer[][] dp;
    int mod=(int)1e9+7;
    public int numberOfWays(String corridor) {
        int n=corridor.length();
        dp=new Integer[n][4];
        return solve(corridor,0,0);
        
    }
    public int solve(String corridor,int index,int seats){
        
        
        if(index==corridor.length()){
            if(seats==2)return 1;
            
            return 0;
        }
        
       if(corridor.charAt(index)=='S')seats++;
        
        if(dp[index][seats]!=null)return dp[index][seats];
        
        int count=0;
       if(seats<2){
           count=((count)%mod+(solve(corridor,index+1,seats))%mod)%mod;
       }else if(seats==2){
           count=(count+(solve(corridor,index+1,0)%mod+(solve(corridor,index+1,seats))%mod))%mod;
       }else{
           return dp[index][seats]= 0;
       }
        
        return dp[index][seats]= count;
        
    }
}