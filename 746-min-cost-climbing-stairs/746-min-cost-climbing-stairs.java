class Solution {
    // Integer[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        
        
        if(n==1||n==0)return n==1?cost[0]:0; 
        
        // int[] dp=new int[n];
        // dp[n-1]=cost[n-1];
        // dp[n-2]=cost[n-2];
        
        if(n==2){
            return Math.min(cost[0],cost[1]);
        }
        int second=cost[n-1];
        int first=cost[n-2];
        
        
        
        int min=(int)1e9;
        if(n-2==1){
            min=first;
        }
        
        for(int i=n-3;i>=0;i--){
            int val=Math.min(first,second);
            int temp=first;
            first=val+cost[i];
            second=temp;
            if(i==1||i==0){
                min=Math.min(min,first);
            }
        }
        
        return min;
    }
    
//     public int solve(int index,int[] cost,int n){
        
// //         
//         if(index>=n)return  0;
        
//         if(dp[index]!=null)return dp[index];  
        
//       int oneStep=  solve(index+1,cost,n);
        
//      int twoStep=   solve(index+2,cost,n);
//         int val= Math.min(oneStep,twoStep)+cost[index];
//      dp[index]=   val;
//         return val;
//     }
}