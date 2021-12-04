class Solution {
    
    public int reductionOperations(int[] nums) {
        int n=nums.length;
        
      
        Arrays.sort(nums);
        
        int count=1,ans=0,prev=nums[n-1];
        
        
        for(int i=n-2;i>=0;i--){
            if(nums[i]<prev){
                ans+=count;
                prev=nums[i];
            }
            count++;
        }
        
        return ans;
        
        
    }
}