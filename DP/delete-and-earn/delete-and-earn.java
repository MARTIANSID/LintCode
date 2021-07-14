class Solution {
    public int deleteAndEarn(int[] nums) {
    
        
        Arrays.sort(nums);
        
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        
        
        return solve(nums,0,dp);
        
    }
    
    
    
    public int solve(int[] nums,int index,int[] dp){
        
        
        if(index==nums.length)
        {
            return 0;
        }       
        
        if(dp[index]!=-1)return dp[index];
        
        int val=0;
        int ele=nums[index];
        
        int in=index;
        
        
          int leave=solve(nums,index+1,dp);
        
        
        
         while(index<nums.length&&nums[index]==ele){
             val+=nums[index];
             index++;
         }
       
        while(index<nums.length&&nums[index]-ele==1){
            index++;
        }
        
        if(in==index){
            index++;
        }
        
        
        int take=solve(nums,index,dp)+val;
        
        
        return dp[in]=Math.max(take,leave);
        
    }
}