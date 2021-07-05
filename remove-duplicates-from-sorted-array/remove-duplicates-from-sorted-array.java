class Solution {
    public int removeDuplicates(int[] nums) {
            int prev=-1,count=1;
            int index=1;
           
        for(int i=1;i<nums.length;i++){
              
                if(nums[i]==nums[i-1]){
                        
                }else{
                        nums[index]=nums[i];
                        count++;
                        index++;
                }
                      
        }
            
           
       
            return count;
    }
}

