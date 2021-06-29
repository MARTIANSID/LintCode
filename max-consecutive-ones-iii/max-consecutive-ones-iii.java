class Solution {
    public int longestOnes(int[] nums, int k) {
        int ei=0,si=0,n=nums.length,max=-(int)1e9,count=0;
            
         while(ei<n){
                  if(nums[ei]==0)count++;
                ei++;
               
                 
                 if(count>k){
                         while(count>k){
                                 if(nums[si]==0){
                                         count--;
                                 }
                                 si++;
                         }
                 }
                 
                 max=Math.max(max,ei-si);
                 
         }   
            
            return max;
    }
}