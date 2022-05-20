class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        
        int ei=k-1,si=0,min=(int)1e9;
        
        while(ei<n){
            min=Math.min(min,nums[ei]-nums[si]);
            ei++;
            si++;
        }
        return min;
    }
}