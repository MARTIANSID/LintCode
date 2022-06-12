class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        
        int si=1,ei=nums.length-1;
        
        while(si<=ei){
            int mid=(si+ei)/2;
            int count=0;
            for(int ele:nums){
                if(ele<=mid)count++;
            }
            if(count>mid){
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }
        return si;
    }
}