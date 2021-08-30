class Solution {
    public int getMaximumConsecutive(int[] nums) {
        
        int range=0;
        
        Arrays.sort(nums);
        
        for(int ele:nums){
            if(ele<=range||ele==range+1){
                range+=ele;
            }else{
                break;
            }
            
        }
        return range+1;
        
    }
}


