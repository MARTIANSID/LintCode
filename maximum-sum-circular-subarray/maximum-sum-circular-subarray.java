class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // [1,-2,3,-2]
        int n=nums.length,currSum=0,global=-(int)1e9,total=0,currSum1=0,min=(int)1e9,maxele=-(int)1e9;
        
        //middle case
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            currSum1+=nums[i];
            currSum1=Math.min(currSum1,nums[i]);
            currSum=Math.max(currSum,nums[i]);
            global=Math.max(global,currSum);
            min=Math.min(min,currSum1);
            total+=nums[i];
            maxele=Math.max(maxele,nums[i]);
        }
        
        if(total-min==0)return global;
        
        return Math.max(total-min,global);
        
      
        
        
    }
}