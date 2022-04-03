class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n=nums.length;
        
        int si=0,ei=nums.length;
        
        while(si<=ei){
            int mid=(si+ei)/2;
            if(isPossible(mid,nums,target)){
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }
        
        
       
        return si==n+1?0:si;
    }
    
    public boolean isPossible(int len,int[] nums,int target){
        
        int si=0,ei=0,n=nums.length,sum=0;
        
        while(ei<n){
            sum+=nums[ei++];
         
            if(ei-si==len){
                if(sum>=target)return true;
                sum-=nums[si++];
            }
        }
        return false;
    }
}