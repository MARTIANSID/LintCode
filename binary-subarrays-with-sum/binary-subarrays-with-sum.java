class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        return  lessThanEqualTo(nums,goal)- lessThanEqualTo(nums,goal-1);
        
    }
    public int lessThanEqualTo(int[] nums,int goal){
        int ei=0,si=0,n=nums.length;
        
        int sum=0,ans=0;
        while(ei<n){
            sum+=nums[ei++];
            
            while(si<ei&&sum>goal){
                sum-=nums[si];
                si++;
            }
            
            ans+=ei-si;
        }
        
        return ans;
    }
}