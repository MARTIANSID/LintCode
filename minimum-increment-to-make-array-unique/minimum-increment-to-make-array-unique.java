class Solution {
    public int minIncrementForUnique(int[] nums) {
        
        Arrays.sort(nums);
            int n=nums.length;
        int ans=0;
            for(int i=1;i<n;i++){
                int prev=nums[i-1];
                    if(prev>=nums[i]){
                        ans+=prev- nums[i]+1;
                        nums[i]+=prev-nums[i]+1;
                    }
            }
        
        return ans;
    }
}

// [2,2,1,1,3]


