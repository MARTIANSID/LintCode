class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n=nums.length;
        int max=0;
        for(int ele:nums){
            max=Math.max(max,ele);
        }
        
        int si=0,ei=max;
        
        while(si<=ei){
            int mid=(si+ei)/2;
            long costC=calc(nums,cost,mid);
            long costU=calc(nums,cost,mid+1);
            
            if(costC<costU){
                ei=mid-1;
            }else{
                si=mid+1;
            }
            
        }
        return calc(nums,cost,si);
    }
    public long calc(int[] nums,int[] cost,int mid){
        long val=0;
    
        for(int i=0;i<nums.length;i++){
            val+=Math.abs((long)nums[i]-(long)mid)*(long)cost[i];
        }
        return val;
    }
}