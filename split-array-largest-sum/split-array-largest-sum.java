class Solution {
    
    public boolean isPossible(int[] nums,int m,int s){
        int sum=0;
        int sub=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>s)return false;
           
            if(nums[i]+sum>s){
                sum=nums[i];
                sub++;
            }else{
                sum+=nums[i];
                
            }
        }
        if(sub<=m)return true;
        else return false;
    }
    
    public int splitArray(int[] nums, int m) {
        int low=0,high=(int)1e9;
        
        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(nums,m,mid)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        
        return low;
    }
}