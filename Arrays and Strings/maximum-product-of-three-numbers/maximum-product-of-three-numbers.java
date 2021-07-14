class Solution {
    public int maximumProduct(int[] nums) {
      //we can find first max second max ,third max similarly for min for time complexity o(n)
            
           Arrays.sort(nums);
            
          return Math.max(nums[0]*nums[1]*nums[nums.length-1],nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1]);
    }
}
