class Solution {
    public boolean isPossible(int[] nums,int threshold,int num){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=(Math.ceil((double)nums[i]/(double)num));
            
        }
        // if(num==3)System.out.println(sum);
        if(sum<=threshold)return true;
        else return false;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        int low=0,high=(int)1e9;
        
        while(low<=high){
            int mid=(low+high)/2;
            
            if(isPossible(nums,threshold,mid)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        
        return low;
    }
}