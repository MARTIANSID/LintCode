class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int ei=0,si=0,max=0,zero=0;
        
        while(ei<n){
            zero+=(1-nums[ei++]);
            while(zero>1){
                zero-=(1-nums[si++]);
            }
            max=Math.max(max,ei-si-1);
        }
        return max;
    }
}