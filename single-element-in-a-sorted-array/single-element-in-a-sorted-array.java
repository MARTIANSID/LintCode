class Solution {
    public int singleNonDuplicate(int[] nums) {
        int   si=0,hi=nums.length-1;
        
        if(nums.length==1)return nums[0];
        
        while(si<=hi){
            int mid=(si+hi)/2;
            if(mid==nums.length-1&&nums[mid-1]!=nums[mid])return nums[mid];
            else if(mid==0&&nums[mid]!=nums[mid+1])return nums[mid];
            else if(mid+1<nums.length&&mid-1>=0&& nums[mid]!=nums[mid+1]&&nums[mid-1]!=nums[mid])return nums[mid];
            else if(mid+1<nums.length&&nums[mid+1]==nums[mid]){
                if((hi-mid+1+1)%2==0){
                    si=mid+2;
                }else{
                    hi=mid-1;
                }
            }else if(mid-1>=0&&nums[mid-1]==nums[mid]){
                 if((mid-si)%2==0){
                   hi=mid-2;
                }else{
                    si=mid+1;
                }
            }
        }
        return nums[si];
    }
}



// [1,1,2]