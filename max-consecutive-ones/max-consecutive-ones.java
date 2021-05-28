class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int si=0,ei=0,n=nums.length,max=0;
            
            while(ei<n){
                    if(nums[ei]==0){
                           ei++;
                            si=ei;
                    }else{
                            ei++;
                    }

                  
                    
                max=    Math.max(max,ei-si);
            }
            return max;
    }
}