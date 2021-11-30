class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        
        int min=(int)1e9,si=0,ei=nums.length-1;
        
        
        while(si<=ei){
            int mid=(si+ei)/2;
            
            min=Math.min(min,nums[mid]);
            min=Math.min(min,nums[ei]);
            min=Math.min(min,nums[si]);

            
            if(nums[mid]>nums[si]){
                si=mid+1;
                min=Math.min(min,nums[si]);
            }else if(nums[mid]<nums[ei]){
                ei=mid-1;
                 min=Math.min(min,nums[mid]);
            }else{
                si++;
                ei--;
            }
        }
        return min;
    }
}