class Solution2{
    static int countMin(String str)
    {
        // code here
        
        int[][] dp=new int[str.length()][str.length()];
        for(int[] row:dp)Arrays.fill(row,-1);
        
        return solve(str,0,str.length()-1,dp);
    }
    public static int solve(String s,int i,int j,int[][] dp){
        
        if(i==j){
            return dp[i][j]=0;
        }
        
        if(dp[i][j]!=-1)return dp[i][j];
        
        if(j<i)return 0;
        
        if(s.charAt(i)==s.charAt(j)){
        return    dp[i][j]=solve(s,i+1,j-1,dp);
        }else{
            
            return dp[i][j]= Math.min(solve(s,i+1,j,dp)+1,solve(s,i,j-1,dp)+1);
        }
        
    }
}