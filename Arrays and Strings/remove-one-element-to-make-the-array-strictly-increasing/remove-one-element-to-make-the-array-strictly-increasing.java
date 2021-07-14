class Solution {
    public boolean canBeIncreasing(int[] nums) {
            int count=0,index=0;
        for(int i=0;i<nums.length-1;i++){
                if(nums[i+1]<=nums[i]){
                        index=i+1;
                        count++;
                }
                if(count>=2)return false;
        }
            
            if(count==0)return true;
            
            if(index==nums.length-1)return true;
            else if(index==1){
                    if(nums.length<3)return true;
                    else{
                            if(nums[0]<nums[2])return true;
                            else if(nums[1]<nums[2])return true;
                            
                    }
                    
            }else{
                    if(nums[index-1]<nums[index+1])return true;
                    else if(nums[index]<nums[index+1]&&nums[index]>nums[index-2])return true;
                    
            }
            
            
            return false;
            
            
    }
}