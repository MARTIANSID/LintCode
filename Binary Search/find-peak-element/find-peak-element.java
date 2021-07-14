class Solution {
    public int findPeakElement(int[] nums) {
        
            int ei=0,hi=nums.length;
        
        while(ei<=hi){
            int mid=(ei+hi)/2;
            if(mid+1<nums.length&&mid-1>=0&&nums[mid-1]<nums[mid]&&nums[mid]>nums[mid+1])return mid;
           else  if(mid+1<nums.length&&nums[mid+1]>nums[mid])ei=mid+1;
            else  hi=mid-1;
            
        }
        
        return ei;
        
        
    }
    
}
// ,1]
        
// [1,2,1,3,5,6,4]
// [1,2,3

