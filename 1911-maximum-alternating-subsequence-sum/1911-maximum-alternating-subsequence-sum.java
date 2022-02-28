 class Solution {
     
     Long[][] dp;
    public long maxAlternatingSum(int[] nums) {
        
        int n=nums.length;
        dp=new Long[2][n];
        
        
        return solve(nums,1,0);
        
        
        
    }
     
     
     public long solve(int[] nums,int operator,int index){
         
         if(index==nums.length)return 0;
         
         if(dp[operator][index]!=null)return dp[operator][index];
         
         
         long x=solve(nums,operator==1?0:1,index+1) + (operator==1?nums[index]:-nums[index]);
         
        long y=solve(nums,operator,index+1);
         
         return dp[operator][index]= Math.max(x,y);
         
     }
     
     
}