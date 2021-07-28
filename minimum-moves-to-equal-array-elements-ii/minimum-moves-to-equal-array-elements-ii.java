class Solution {
    public int minMoves2(int[] nums) {
        
        Arrays.sort(nums);
        int n=nums.length,midval=nums[n/2];
        
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans+=Math.abs(midval-nums[i]);
        }
        
        return ans;
        
    }
}

// [1,2,9,10]

