class Solution {
    public int searchInsert(int[] nums, int target) {
       
     int ei=nums.length-1,si=0;
            
            while(si<=ei){
                    
                    int mid=(si+ei)/2;
                    
                    if(nums[mid]==target)
                            return mid;
                    else if(nums[mid]>target)ei=mid-1;
                    else si=mid+1;
            }
            
            return si;
    }
}