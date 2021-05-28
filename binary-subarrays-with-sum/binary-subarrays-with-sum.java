class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
     
            return atMost(nums,goal)-atMost(nums,goal-1);
            
    }
        public int atMost(int[] nums,int goal){
        int si=0,ei=0,count=0,n=nums.length,sum=0;
            
         while(ei<n){
                 sum+=nums[ei];
                 ei++;
                 
                 while(sum>goal&&si<n){
                         
                         sum-=nums[si];
                       si++;
                 }
                 if(sum<=goal&&si<=ei)
                 count+=ei-si;
         }
            return count;
        }
}