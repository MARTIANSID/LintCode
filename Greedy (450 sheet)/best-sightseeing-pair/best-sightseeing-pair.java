class Solution {
    public int maxScoreSightseeingPair(int[] nums) {
        int n=nums.length;
        
        int max=nums[0]-1,ans=0;
        
        for(int i=1;i<n;i++){
            ans=Math.max(ans,nums[i]+max);
            max=Math.max(max,nums[i]);
            max--; 
        }
        return ans;
    }
    
}
