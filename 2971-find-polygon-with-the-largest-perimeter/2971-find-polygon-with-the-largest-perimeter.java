class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        
        if(n<3)return -1;
        
        Arrays.sort(nums);
        
        long sum = 0;
        
        for(int ele:nums){
            sum+=ele;
        }
        
        for(int i=n-1;i>=2;i--){
            long ans = sum;
            sum-=nums[i];
            
            if(sum>nums[i])return ans;
            
        }
        return -1;
    }
}