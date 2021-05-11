class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
     
            
            int[][] dp=new int[dungeon.length+1][dungeon[0].length+1];
            return solve(dungeon,0,0,dp);
    }
        
        public int solve(int[][] dungeon,int row,int col,int[][] dp){
                
                
             if(row>=dungeon.length||col>=dungeon[0].length){
                       return (int)1e9;
               }      
                
                if(dp[row][col]!=0)return dp[row][col];
                
             int health=  Math.min(solve(dungeon,row+1,col,dp),solve(dungeon,row,col+1,dp));   
                
                
                if(health==(int)1e9)health=1;
                
                if(health-dungeon[row][col]>0)
                        health=health-dungeon[row][col];
                  else
                          health=1;
                
                
                
                
                        
             return dp[row][col]=health;           
                
                
                
        }
}