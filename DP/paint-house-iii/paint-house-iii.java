class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
           
            
            int[][][] dp=new int[cost.length+1][target+1][n+2];
           
            for(int[][] r:dp)for(int[] row:r)Arrays.fill(row,-1);
                         int x= solve(houses,cost,target,0,n+1,n,m,dp);

 int ans=   x==(int)1e9?-1:x;
            
            return ans;
    }
        
        public int solve(int[] houses,int[][] cost,int target,int index,int prevColor,int n,int m,int[][][] dp){
                
            if(index==houses.length){
                    if(target==0) return dp[index][target][prevColor] =  0;
                    else return  dp[index][target][prevColor] =(int)1e9;
            }
                
                // if(target==0)return (int)1e9;
                
                if(dp[index][target][prevColor] !=-1)return dp[index][target][prevColor] ;
                
          if(houses[index]!=0){
        
              if(prevColor==houses[index]){
                return dp[index][target][prevColor] = solve(houses,cost,target,index+1,prevColor,n,m,dp);
              }  else{
                        if(target-1>=0)    
                      return dp[index][target][prevColor] =solve(houses,cost,target-1,index+1,houses[index],n,m,dp);
              } 
                
                  
          }else{
               int[] c=cost[index];
                  // System.out.println(c[0]);
                int max=(int)1e9;
               for(int i=1;i<=c.length;i++){
                       if(prevColor==i){
                                     max=Math.min(max,solve(houses,cost,target,index+1,prevColor,n,m,dp)+c[i-1]);
                       }else{
                              
                if(target-1>=0)                                                                      max=Math.min(max,solve(houses,cost,target-1,index+1,i,n,m,dp)+c[i-1]);
 
                       }
               }  
                  
                  return dp[index][target][prevColor] = max;
                  
                  
          }      
                
                return dp[index][target][prevColor] = (int)1e9;
                
        }
}