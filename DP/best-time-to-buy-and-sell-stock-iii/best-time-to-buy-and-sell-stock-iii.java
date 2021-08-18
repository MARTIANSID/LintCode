class Solution {
    public int maxProfit(int[] prices) {
        
        int[][][] dp=new int[prices.length+1][2][3];
        
        for(int[][] row:dp)for(int[] r:row)Arrays.fill(r,-1);
        
        return solve(prices,0,1,2,dp);
    }
    
    public int solve(int[] prices,int index,int buy,int transactions,int[][][] dp){
        
        
        if(index>=prices.length)return  dp[index][buy][transactions]= 0;
        
        if(transactions==0)return   dp[index][buy][transactions]= 0;
        
        
        if( dp[index][buy][transactions]!=-1)return  dp[index][buy][transactions];
       
         if(buy==1){
             
           int x=  solve(prices,index+1,0,transactions,dp)-prices[index];
            int y= solve(prices,index+1,1,transactions,dp);
             
             return  dp[index][buy][transactions]=  Math.max(x,y);
             
             
         }else{
             
            int x= solve(prices,index+1,1,transactions-1,dp)+prices[index];
            int y= solve(prices,index+1,0,transactions,dp);
             
               return  dp[index][buy][transactions]= Math.max(x,y);
         }
        
        
    }
}