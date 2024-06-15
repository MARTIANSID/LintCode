class Solution {
    public int minIncrementForUnique(int[] nums) {
        
        int n = nums.length, moves = 0;
        
        Arrays.sort(nums);
        
        for(int i = 1; i < n; i++){
            if(nums[i] <= nums[i-1]) {
                moves += (nums[i-1]+1-nums[i]);
                nums[i] = nums[i-1] + 1;
                
            }
            
        }
        return moves;
        
    }
}

// [7,3,2,2,1,1]
// 2
// []

// 1,1,2,2,3,7
// 1,2,3,4,5,7