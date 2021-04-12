// find the longest common subsequence and then subtract it from the sum of the length of the strings

class Solution{
    public static int shortestCommonSupersequence(String X, String Y, int m, int n)
    {
         int[][] dp=new int[m+1][n+1];
    for(int[] row:dp)Arrays.fill(row,-1);
        int x=solve(X,Y,0,0,dp);
   
        return X.length()+Y.length()- x;
    }
    public static int solve(String x,String y,int i,int j,int[][] dp){
        
        if(i==x.length()||j==y.length()){
            return dp[i][j]= 0;
        }
        
        if(dp[i][j]!=-1)return dp[i][j];
        
        
        if(x.charAt(i)==y.charAt(j)){
            
         int p=   solve(x,y,i+1,j+1,dp)+1;
       
       return dp[i][j]=p;
        }else{
            int l= Math.max(solve(x,y,i+1,j,dp),solve(x,y,i,j+1,dp));
         return dp[i][j]=l;
            
            
        }
        
    }
}