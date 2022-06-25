class Solution {
    
    /*
    
    
    
    [1,2,3,4,4,1,2,3,] (i+1 should be >= i-1, i is the breaking point)
    
    if 2 break points are there then it is not possible
    
    [1,2,2,0,-1,2,3,4]
    
    

    */
        
    public boolean checkPossibility(int[] nums) {
        int n=nums.length,breakPoints=0;
        
        int max=-(int)1e9;
        
        for(int i=0;i<n-1;i++){
            if(i==0){
                if(nums[i]>nums[i+1]){
                    breakPoints++;
                }
            }else{
                if(nums[i]>nums[i+1]){
                    if(max<=nums[i+1]){
                        
                    }else{
                        nums[i+1]=nums[i];
                    }
                    breakPoints++;
                }
            }
            max=Math.max(max,nums[i]);
            if(breakPoints>=2)return false;
        }
        return true;
        
    }
}