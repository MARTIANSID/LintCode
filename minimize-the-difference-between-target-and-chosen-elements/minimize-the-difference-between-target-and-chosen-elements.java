class Solution {
    Integer[][] dp;
    public int minimizeTheDifference(int[][] mat, int target) {
        dp=new Integer[mat.length+1][5001];
        return solve(mat,0,0,target);
    }
    
    public int solve(int[][] mat,int target,int row,int t){
        

        
        
        if(row==mat.length)return Math.abs(t-target);
        
        if(dp[row][target]!=null)return dp[row][target];
        
        int min =(int)1e9;
        
        
        
        for(int i=0;i<mat[row].length;i++){
                min=Math.min(min,solve(mat,target+mat[row][i],row+1,t));
        
        }
        
        return  dp[row][target]= min; 
        
        
    }
}