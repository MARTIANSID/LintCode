class Solution {
    Integer[][] dp;
    public int tallestBillboard(int[] rods) {
        int n=rods.length,sum=0;
       
        dp=new Integer[n+1][(int)1e5];
        
        return solve(rods,0,0);
        
    }
    public int solve(int[] roads,int index,int sL){
        
        if(index == roads.length){
            
            if(sL == 0)return 0;
            
            return -(int)1e9;
        }
        
        if(dp[index][sL+5010]!=null)return dp[index][sL+5010];
        
        
     
        
        int s1=solve(roads,index+1,sL+roads[index])+roads[index];
        int s2=solve(roads,index+1,sL);
        int s3=solve(roads,index+1,sL-roads[index]);
        
        return dp[index][sL+5010]=Math.max(s1,Math.max(s2,s3));
        
    }
}