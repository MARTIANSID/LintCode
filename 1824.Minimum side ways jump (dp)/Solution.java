class Solution {
    public int minSideJumps(int[] obstacles) {
            int n=obstacles.length;
            
            
            int[][] dp=new int[4][n+1];
            for(int[] row:dp)Arrays.fill(row,-1);
            
        return solve(obstacles,0,obstacles.length,2,dp);
    }
        public int solve(int[] obstacles,int index,int n,int lane,int[][] dp){
                if(index==n){
                        return dp[lane][index]=0;
                }
                
                if(dp[lane][index]!=-1)return dp[lane][index];
                
                
                if(lane==2){
                        
                     if(index+1<n&&obstacles[index+1]!=2||index+1==n){
                           return  dp[lane][index]= solve(obstacles,index+1,n,lane,dp);
                     }else{
                             int x=(int)1e9;
                             int y=(int)1e9;
                             
                             if(obstacles[index]!=1)
                            x= solve(obstacles,index,n,1,dp)+1;
                             
                             if(obstacles[index]!=3)
                               y= solve(obstacles,index,n,3,dp)+1;
                             
                             return dp[lane][index]=Math.min(x,y);
                             
                     }
                        
                }else if(lane==1){
                        
                          if(index+1<n&&obstacles[index+1]!=1||index+1==n){
                           return  dp[lane][index]= solve(obstacles,index+1,n,lane,dp);
                     }else {
                                  
                                int x=(int)1e9;
                             int y=(int)1e9;
                             
                             if(obstacles[index]!=2)
                            x= solve(obstacles,index,n,2,dp)+1;
                             
                             if(obstacles[index]!=3)
                               y= solve(obstacles,index,n,3,dp)+1;
                             
                             return dp[lane][index]=Math.min(x,y);
                                  
                                  
   
                          }
                        
                        
                }else{
                        
                          if(index+1<n&&obstacles[index+1]!=3||index+1==n){
                           return   dp[lane][index]=solve(obstacles,index+1,n,lane,dp);
                     }else{
                                  
                                int x=(int)1e9;
                             int y=(int)1e9;
                             
                             if(obstacles[index]!=1)
                            x= solve(obstacles,index,n,1,dp)+1;
                             
                             if(obstacles[index]!=2)
                               y= solve(obstacles,index,n,2,dp)+1;
                             
                             return dp[lane][index]=Math.min(x,y);
                                  
                                  
                                  
                          }
                        
                        
                        
                        
                }
        }
}