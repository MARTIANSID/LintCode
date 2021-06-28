class Solution {
    public int search(int[] nums, int target) {
     int si=0,ei=nums.length-1;
            
            
          while(si<=ei){
                  int mid=(ei+si)/2;
                  if(nums[mid]==target)return mid;
                  else if(nums[mid]>target)ei=mid-1;
                  else si=mid+1;
          }
            return -1;
    }
}