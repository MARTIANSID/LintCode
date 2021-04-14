class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp=new int[strs.length+1][m+1][n+1];
            
            for(int[][] r:dp)for(int[] row:r)Arrays.fill(row,-1);
            
            return solve(strs,m,n,0,dp);
    }
        
        
        public int solve(String[] strs,int m,int n,int index,int[][][] dp){
                
             
                
                if(m==0&&n==0){
                        return dp[index][m][n]= 0;
                }
                
                if(m<0||n<0){
                        return -(int)1e9;
                }
                
                   if(index==strs.length){
                        return dp[index][m][n]=0;
                }
                
                
                if(dp[index][m][n]!=-1)return dp[index][m][n];
                
                
                
                int z =zereos(strs[index]);
                int o=strs[index].length()-z;
              int x=  solve(strs,m-z,n-o,index+1,dp)+1;
                
            int y=    solve(strs,m,n,index+1,dp);
                
                return dp[index][m][n]=Math.max(x,y);
                
                
                
        }
        
        public int zereos(String s){
                
                int z=0;
                for(int i=0;i<s.length();i++){
                        if(s.charAt(i)=='0')z++;
                }
                
                return z;
        }
}