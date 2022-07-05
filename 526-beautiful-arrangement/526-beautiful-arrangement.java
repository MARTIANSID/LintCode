class Solution {
    Integer[][] dp;
    public int countArrangement(int n) {
        dp=new Integer[n][1<<n+1];
        
        return dfs(0,n,0);
    }
    public int dfs(int index,int n,int mask){
        
        if(index==n){
            return  1;
        }
        if(dp[index][mask]!=null)return dp[index][mask];
        
        int count=0;
        for(int i=1;i<=n;i++){
            int x=(1<<(i-1));
            if((x&mask)==0 && (((index+1)%i==0)||(i%(index+1)==0))){
                count+=dfs(index+1,n,(mask|x));
            }
        }
        return dp[index][mask]=count;
    }
}


// 1,2
