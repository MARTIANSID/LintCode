class Solution {
    public int majorityElement(int[] nums) {
            int count=0;
            int ansIndex=0;
        for(int i=0;i<nums.length;i++){
                if(nums[i]==nums[ansIndex]){
                        count++;
                }else{
                        count--;
                }
                
                if(count==0){
                        ansIndex=i;
                        count=1;
                        
                }
                
                
        }
            return   nums[ansIndex];
    }
        
}


// [1,2,1,1,1,2,2,3,3]

