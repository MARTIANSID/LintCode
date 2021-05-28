public class Solution {
    /**
     * @param nums: a list of integer
     * @return: return a integer, denote  the maximum number of consecutive 1s
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int countOfZero=0, countOfOne=0,n=nums.length,si=0,ei=0,max=0;

        while(ei<n){
            if(nums[ei]==0){
                countOfZero++;
            }
            ei++;

            while(countOfZero>1){
                if(nums[si]==0){
                    countOfZero--;
                }
                si++;
            }
            max=Math.max(max,ei-si);
        }
        return max;
    }
}