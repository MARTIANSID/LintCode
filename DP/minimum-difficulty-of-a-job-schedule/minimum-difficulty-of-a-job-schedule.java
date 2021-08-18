class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        
        
        
        int[][] dp=new int[jobDifficulty.length+1][d+1];
        for(int[] row:dp)Arrays.fill(row,-1);
           int ans= solve(jobDifficulty,d,0,dp);
        return ans==(int)1e9?-1:ans;
            
    }
    
    public int solve(int[] job,int d,int si,int[][] dp){
        
       if(si==job.length&&d>0)return   dp[si][d]= (int)1e9;
        
        
        if( dp[si][d]!=-1)return  dp[si][d];
        
    if(d==1){
        int max=0;
        for(int i=si;i<job.length;i++){
            max=Math.max(max,job[i]);
        }
        
        return   dp[si][d]= max;
    }
        
        
        
        int max=0;
        int msum=(int)1e9;
        for(int i=si;i<job.length;i++){
            max=Math.max(max,job[i]);
            msum=Math.min(msum,solve(job,d-1,i+1,dp)+max);
        }
        return   dp[si][d]=msum;
    }
}


