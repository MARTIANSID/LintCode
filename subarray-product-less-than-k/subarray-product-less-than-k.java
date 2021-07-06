class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
            
            //will only work if array does not contain negetive numbers
            
        int si=0,ei=0,n=nums.length,prod=1,count=0;
            
          while(ei<n){
                prod*=nums[ei];
                ei++;
                while(si<ei&&prod>=k){
                        prod /=nums[si];
                        si++;
                }
                  
                  
                  count+=ei-si;
                  
          }
            return count;
    }
}


   
          
     