class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
       int n=nums.length,max=-(int)1e9;
        for(int i=0;i<n/2;i++){
                max=Math.max(max,nums[i]+nums[n-i-1]);
        }
            return max;
    }
}

// [2,3,3,5]