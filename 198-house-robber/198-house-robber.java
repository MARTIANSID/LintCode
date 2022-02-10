class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        
        if(n==1)return nums[0];
        
        if(n==2)return Math.max(nums[0],nums[1]);
        
        
        
        
        
        int include=nums[n-1];
        int dontInclude=Math.max(nums[n-2],nums[n-1]);
        
        for(int i=n-3;i>=0;i--){
            int x=Math.max(include+nums[i],dontInclude);
            include=dontInclude;
            dontInclude=x;
        }
        
        return dontInclude;
    }
    
//     public int solve(int index,int [] nums){
        
//         solve(index+1,nums);
//         solve(index+2,nums);
//     }
}