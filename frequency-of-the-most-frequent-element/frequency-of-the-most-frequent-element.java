class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n=nums.length,ei=0,si=0,max=1;
        long sum=0;
        
        Arrays.sort(nums);
        
        while(ei<n){
          sum+=nums[ei++];
        
            while(sum+k<(long)((nums[ei-1]*(ei-si)))){
                
                sum-=nums[si];
                si++;
                
            }
            
            max=Math.max(max,ei-si);
            
        }
        
        return max;
        
    }
}