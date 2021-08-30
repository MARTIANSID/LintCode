class Solution {
    public int minPatches(int[] nums, int n) {
         int size=nums.length,patch=0,i=0;
       long range=0;
        
        while(range<n){
            if(i<size&&(nums[i]==range+1||nums[i]<=range)){
                range+=nums[i];
                i++;
            }else{
                range+=range+1;
                patch++;
            }
            
        }
        return patch;
    }
}