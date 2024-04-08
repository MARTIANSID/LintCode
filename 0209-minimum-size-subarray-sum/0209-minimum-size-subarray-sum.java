class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n = nums.length, si = 0, ei = 0, min = (int)1e9, sum = 0;
        
        
        
        while(ei < n){          
            sum += nums[ei++];        
            
            while(sum >= target){
                min = Math.min(min,ei-si);
               
                sum-= nums[si++];
            }
        }
        
        if(min == (int)1e9){
            return 0;
        }
        
        return min;
        
    }
}


// sliding window  o(2*n) - o(n)

// [2,3,1,2,4,3]
// 2 - sum = 2
// 2,3 - sum = 5
// 2,3,1 - sum = 6
// 2,3,1,2 - sum = 8  (0th index - 4)
// 3,1,2 - sum = 6
// 3,1,2,4 - sum = 10 (1st index - 4)
// 1,2,4 - sum = 7 (2nd index - 3)
// 2,4 - sum = 6
// 2,4,3 - sum = 9 (3rd index - 3)
// 4,3 - sum = 7 (4th index - 2)
// 3 - sum = 3 (terminate)

