class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int n=nums.length;
        int lo=1,hi=(int)1e9;
        
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(isPossible(mid,nums,maxOperations)){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }
    
    public boolean isPossible(int maxVal,int[] nums,int maxOperations){
        int total=0;
        for(int ele:nums){
           
            int val=ele%maxVal==0?ele/maxVal-1:ele/maxVal;
            if(ele>maxVal && (total+val)>maxOperations){
                return false;
            }
            total+=val;
        }
        return true;
    }
}